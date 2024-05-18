package br.com.franca.clinicamedica.usecases.convenio;

import br.com.franca.clinicamedica.gateways.ConvenioGateway;
import br.com.franca.clinicamedica.repositories.ConvenioRepository;
import br.com.franca.clinicamedica.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteConvenioUseCase {


    private final ConvenioRepository convenioRepository;
    private final PacienteRepository pacienteRepository;
    private final ConvenioGateway convenioGateway;



    @Autowired
    public DeleteConvenioUseCase(ConvenioRepository convenioRepository, PacienteRepository pacienteRepository, ConvenioGateway convenioGateway) {
        this.convenioRepository = convenioRepository;
        this.pacienteRepository = pacienteRepository;
        this.convenioGateway = convenioGateway;
    }

    public void deleteConvenio(Long id) {

        // Regra 1: Verificar se o convênio existe
        if (!convenioRepository.existsById(id)) {
            throw new IllegalArgumentException("Convênio não encontrado.");
        }

        // Regra 2: Verificar se o convênio está associado a algum paciente
        if (pacienteRepository.existsByConvenioId(id)) {
            throw new IllegalArgumentException("Não é possível deletar o convênio, pois está associado a um ou mais pacientes.");
        }
        convenioGateway.deleteById(id);
    }
}
