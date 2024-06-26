package br.com.franca.clinicamedica.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "enfermeiro")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enfermeiro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enfermeiro", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "nome_enfermeiro", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nomeEnfermeiro;

    @Column(name = "cpf_enfermeiro", nullable = false, columnDefinition = "VARCHAR(255)")
    private String cpf_enfermeiro;

    @Column(name = "cre_enfermeiro", nullable = false, columnDefinition = "VARCHAR(255)")
    private String creEnfermeiro;

    @Column(name = "email_medico", nullable = false, columnDefinition = "VARCHAR(255)")
    private String emailMedico;
}
