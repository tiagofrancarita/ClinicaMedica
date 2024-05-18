package br.com.franca.clinicamedica.usecases.convenio;

import br.com.franca.clinicamedica.dtos.ConvenioDTO;
import br.com.franca.clinicamedica.entities.Convenio;
import br.com.franca.clinicamedica.entities.TipoPlano;
import br.com.franca.clinicamedica.gateways.ConvenioGateway;
import br.com.franca.clinicamedica.repositories.ConvenioRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreateConvenioUseCase {


    private final ConvenioGateway convenioGateway;
    private final ConvenioRepository convenioRepository;
    private final ModelMapper modelMapper;

    private Logger log = LoggerFactory.getLogger(CreateConvenioUseCase.class);

    @Autowired
    public CreateConvenioUseCase(ConvenioGateway convenioGateway, ConvenioRepository convenioRepository, ModelMapper modelMapper) {
        this.convenioGateway = convenioGateway;
        this.convenioRepository = convenioRepository;
        this.modelMapper = modelMapper;
    }


    public ConvenioDTO createConvenio(ConvenioDTO convenioDTO) {

        log.info("------------------ Iniciando o cadastro do convenio ------------------------------");
        Convenio convenio = modelMapper.map(convenioDTO, Convenio.class);
        validateConvenio(convenio);
        List<TipoPlano> tipoPlanos = convenio.getTipoPlano();
        for (TipoPlano tipoPlano : tipoPlanos) {
            tipoPlano.setConvenio(convenio);
        }
        convenio = convenioGateway.save(convenio);
        return modelMapper.map(convenio, ConvenioDTO.class);
    }

    private void validateConvenio(Convenio convenio) {


        log.info("------------------ Iniciando validação dos dados  ------------------------------");

        // Regra 1: Verificar se o nome do convênio já existe
        Optional<Convenio> existingConvenio = convenioRepository.findByNome(convenio.getNome());
        if (existingConvenio.isPresent()) {
            log.error("------------------ Já existe um convênio com esse nome. ------------------------------");
            throw new IllegalArgumentException("Já existe um convênio com esse nome.");

        }

        // Regra 2: Validar se o convênio possui pelo menos um tipo de plano
        if (convenio.getTipoPlano() == null || convenio.getTipoPlano().isEmpty()) {
            throw new IllegalArgumentException("O convênio deve ter pelo menos um tipo de plano.");
        }

        // Regra 3: Validações de campo
        if (convenio.getNome() == null || convenio.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do convênio é obrigatório.");
        }

        // Regra 4: Validações de campo status
        if (convenio.getStatusConvenio() == null ) {
            throw new IllegalArgumentException("O nome do convênio é obrigatório.");
        }

        // Regra 5: valida CNPJ
        validateCnpj(convenio.getCnpj());

        // Regra 6: Verificar se o CNPJ já está em uso
        Optional<Convenio> existingConvenioByCnpj = convenioRepository.findByCnpj(convenio.getCnpj());
        if (existingConvenioByCnpj.isPresent()) {
            throw new IllegalArgumentException("Já existe um convênio com esse CNPJ.");
        }

        // Regra 7: Verificar se o registro Ans do convênio já existe
        Optional<Convenio> existingRegistroAns = convenioRepository.findByRegistroAns(convenio.getRegistroAns());
        if (existingRegistroAns.isPresent()) {
            throw new IllegalArgumentException("Já existe um convênio com esse registro ans.");
        }

    }

    private void validateCnpj(String cnpj) {
        if (cnpj == null || cnpj.trim().isEmpty()) {
            throw new IllegalArgumentException("O CNPJ é obrigatório.");
        }

        if (!isValidCnpj(cnpj)) {
            throw new IllegalArgumentException("O CNPJ fornecido é inválido.");
        }
    }
    // Método para validar o CNPJ
    private boolean isValidCnpj(String cnpj) {
        cnpj = cnpj.replaceAll("\\D", ""); // Remove caracteres não numéricos

        if (cnpj.length() != 14) {
            return false;
        }

        int[] weights = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        try {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < 12; i++) {
                int digit = Character.getNumericValue(cnpj.charAt(i));
                sum1 += digit * weights[i + 1];
                sum2 += digit * weights[i];
            }

            int checkDigit1 = 11 - (sum1 % 11);
            checkDigit1 = checkDigit1 > 9 ? 0 : checkDigit1;
            sum2 += checkDigit1 * weights[12];

            int checkDigit2 = 11 - (sum2 % 11);
            checkDigit2 = checkDigit2 > 9 ? 0 : checkDigit2;

            return checkDigit1 == Character.getNumericValue(cnpj.charAt(12)) &&
                    checkDigit2 == Character.getNumericValue(cnpj.charAt(13));
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
