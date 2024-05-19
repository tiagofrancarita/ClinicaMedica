package br.com.franca.clinicamedica.usecases.convenio;

import br.com.franca.clinicamedica.gateways.ConvenioGateway;
import br.com.franca.clinicamedica.repositories.ConvenioRepository;
import br.com.franca.clinicamedica.repositories.PacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteConvenioUseCase {


    private final ConvenioRepository convenioRepository;
    private final PacienteRepository pacienteRepository;
    private final ConvenioGateway convenioGateway;

    private Logger logger = LoggerFactory.getLogger(CreateConvenioUseCase.class);




    @Autowired
    public DeleteConvenioUseCase(ConvenioRepository convenioRepository, PacienteRepository pacienteRepository, ConvenioGateway convenioGateway) {
        this.convenioRepository = convenioRepository;
        this.pacienteRepository = pacienteRepository;
        this.convenioGateway = convenioGateway;
    }

    public void deleteConvenio(Long id) {
        // Log: Iniciando o método deleteConvenio para o ID: {id}
        logger.info("Iniciando o método deleteConvenio para o ID: {}", id);

        // Regra 1: Verificar se o convênio existe
        if (!convenioRepository.existsById(id)) {
            // Log: Convênio com ID {id} não encontrado, lançando exceção.
            logger.error("Convênio com ID {} não encontrado, lançando exceção.", id);
            throw new IllegalArgumentException("Convênio não encontrado.");
        }

        // Regra 2: Verificar se o convênio está associado a algum paciente
        if (pacienteRepository.existsByConvenioId(id)) {
            // Log: Convênio com ID {id} está associado a um ou mais pacientes, impossibilitando a exclusão.
            logger.error("Convênio com ID {} está associado a um ou mais pacientes, impossibilitando a exclusão.", id);
            throw new IllegalArgumentException("Não é possível deletar o convênio, pois está associado a um ou mais pacientes.");
        }

        // Log: Excluindo convênio com ID {id}.
        logger.info("Excluindo convênio com ID {}.", id);
        convenioGateway.deleteById(id);

        // Log: Convênio com ID {id} excluído com sucesso.
        logger.info("Convênio com ID {} excluído com sucesso.", id);
    }
}
