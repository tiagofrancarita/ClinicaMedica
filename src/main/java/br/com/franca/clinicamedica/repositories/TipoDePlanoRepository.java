package br.com.franca.clinicamedica.repositories;

import br.com.franca.clinicamedica.entities.TipoPlano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDePlanoRepository extends JpaRepository<TipoPlano, Long> {
}
