package br.com.franca.clinicamedica.usecases.convenio;

import br.com.franca.clinicamedica.entities.Convenio;
import br.com.franca.clinicamedica.gateways.ConvenioGateway;
import br.com.franca.clinicamedica.repositories.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetConvenioUseCase {

    private final ConvenioRepository convenioRepository;
    private final ConvenioGateway convenioGateway;

    @Autowired
    public GetConvenioUseCase(ConvenioRepository convenioRepository, ConvenioGateway convenioGateway) {
        this.convenioRepository = convenioRepository;
        this.convenioGateway = convenioGateway;
    }

    public Optional<Convenio> getConvenio(Long id) {
        // Regras de negócio podem ser aplicadas aqui
        return convenioGateway.findById(id);
    }
}