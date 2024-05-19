package br.com.franca.clinicamedica.usecases.convenio;

import br.com.franca.clinicamedica.entities.Convenio;
import br.com.franca.clinicamedica.repositories.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetConvenioUseCase {

    private final ConvenioRepository convenioRepository;


    @Autowired
    public GetConvenioUseCase(ConvenioRepository convenioRepository) {
        this.convenioRepository = convenioRepository;

    }

    public Optional<Convenio> execute(Long id) {
        // Regra 1: Validar o ID do Convênio
        if (id <= 0 || !convenioRepository.existsById(id)) {
            throw new IllegalArgumentException("ID de convênio inválido ou convênio não encontrado.");
        }

        // Buscar o convênio no banco de dados
        Optional<Convenio> convenioOptional = convenioRepository.findById(id);

        return convenioOptional;
    }
}