package br.com.franca.clinicamedica.repositories;

import br.com.franca.clinicamedica.entities.Convenio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Long> {

    Optional<Convenio> findByNome(String nome);

    Optional<Convenio> findByCnpj(String cnpj);

    Optional<Convenio> findByRegistroAns(String registroAns);

    Page<Convenio> findAll(Pageable pageable);

    boolean existsByCnpjAndIdNot(String cnpj, Long id);

    Optional<Convenio> findById(Long id);

    boolean existsById(Long id);


}
