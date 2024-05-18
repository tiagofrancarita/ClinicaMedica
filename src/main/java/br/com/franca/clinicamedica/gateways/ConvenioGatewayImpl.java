package br.com.franca.clinicamedica.gateways;

import br.com.franca.clinicamedica.entities.Convenio;
import br.com.franca.clinicamedica.repositories.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ConvenioGatewayImpl implements ConvenioGateway{

    private final ConvenioRepository convenioRepository;

    @Autowired
    public ConvenioGatewayImpl(ConvenioRepository convenioRepository) {
        this.convenioRepository = convenioRepository;
    }

    @Override
    public Convenio save(Convenio convenio) {
        return convenioRepository.save(convenio);
    }

    @Override
    public Optional<Convenio> findById(Long id) {
        return convenioRepository.findById(id);
    }

    @Override
    public Page<Convenio> findAll(Pageable pageable) {
        return convenioRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        convenioRepository.deleteById(id);

    }
}
