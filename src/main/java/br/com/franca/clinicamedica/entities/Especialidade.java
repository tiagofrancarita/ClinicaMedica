package br.com.franca.clinicamedica.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "especialidade")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Especialidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidade", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "nome_especialidade", nullable = false, columnDefinition = "VARCHAR(255)")
    private String especialidade;

}