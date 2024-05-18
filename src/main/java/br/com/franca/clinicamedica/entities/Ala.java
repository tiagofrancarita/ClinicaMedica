package br.com.franca.clinicamedica.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ala")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ala implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ala", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "descricao_ala", nullable = false, columnDefinition = "VARCHAR(255)")
    private String descricaoAla;
}
