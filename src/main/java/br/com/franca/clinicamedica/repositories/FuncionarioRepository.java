package br.com.franca.clinicamedica.repositories;


import br.com.franca.clinicamedica.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findById(Long id);

    Funcionario save(Funcionario funcionario);

    void deleteById(Long id);
}
