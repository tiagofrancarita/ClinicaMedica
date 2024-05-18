package br.com.franca.clinicamedica.usecases.convenio;

import br.com.franca.clinicamedica.entities.Convenio;
import br.com.franca.clinicamedica.gateways.ConvenioGateway;
import br.com.franca.clinicamedica.repositories.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ListConvenioUseCase {

    private final ConvenioRepository convenioRepository;
    private final ConvenioGateway convenioGateway;

    @Autowired
    public ListConvenioUseCase(ConvenioRepository convenioRepository, ConvenioGateway convenioGateway) {
        this.convenioRepository = convenioRepository;
        this.convenioGateway = convenioGateway;
    }

    public Page<Convenio> listAllConvenios(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return convenioGateway.findAll(pageable);
    }
}
