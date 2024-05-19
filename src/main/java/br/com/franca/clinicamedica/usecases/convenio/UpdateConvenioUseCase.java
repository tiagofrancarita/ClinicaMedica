package br.com.franca.clinicamedica.usecases.convenio;

import br.com.franca.clinicamedica.entities.Convenio;
import br.com.franca.clinicamedica.repositories.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateConvenioUseCase {

    private final ConvenioRepository convenioRepository;

    @Autowired
    public UpdateConvenioUseCase(ConvenioRepository convenioRepository) {
        this.convenioRepository = convenioRepository;
    }

    public Convenio updateConvenio(Convenio convenio) {
        // Regra 1: Verificar se o convênio existe
        Optional<Convenio> existingConvenio = convenioRepository.findById(convenio.getId());
        if (existingConvenio.isEmpty()) {
            throw new IllegalArgumentException("Convênio não encontrado.");
        }

        // Regra 2: Validação de dados
        validateConvenio(convenio);

        // Regra 3: Verificar se o CNPJ é único
        if (convenioRepository.existsByCnpjAndIdNot(convenio.getCnpj(), convenio.getId())) {
            throw new IllegalArgumentException("CNPJ já cadastrado para outro convênio.");
        }

        return convenioRepository.save(convenio);
    }

    private void validateConvenio(Convenio convenio) {

        if (convenio.getNome() == null || convenio.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do convênio não pode ser vazio.");
        }
        if (convenio.getCnpj() == null || !isValidCnpj(convenio.getCnpj())) {
            throw new IllegalArgumentException("CNPJ inválido.");
        }

        // Outras validações podem ser adicionadas aqui
    }

    private boolean isValidCnpj(String cnpj) {
        if (cnpj == null || cnpj.length() != 14 || !cnpj.matches("\\d{14}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += Character.getNumericValue(cnpj.charAt(i)) * (13 - i);
        }
        int remainder = sum % 11;
        int digit1 = remainder < 2 ? 0 : 11 - remainder;

        // Verifica o primeiro dígito verificador
        if (Character.getNumericValue(cnpj.charAt(12)) != digit1) {
            return false;
        }

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += Character.getNumericValue(cnpj.charAt(i)) * (14 - i);
        }
        remainder = sum % 11;
        int digit2 = remainder < 2 ? 0 : 11 - remainder;

        // Verifica o segundo dígito verificador
        return Character.getNumericValue(cnpj.charAt(13)) == digit2;
    }
}