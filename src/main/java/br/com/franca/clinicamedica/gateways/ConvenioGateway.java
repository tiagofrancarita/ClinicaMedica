package br.com.franca.clinicamedica.gateways;

import br.com.franca.clinicamedica.entities.Convenio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ConvenioGateway {

    Convenio save(Convenio convenio);
    Optional<Convenio> findById(Long id);
    Page<Convenio> findAll(Pageable pageable);
    void deleteById(Long id);
}
