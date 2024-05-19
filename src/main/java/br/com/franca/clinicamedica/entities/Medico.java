package br.com.franca.clinicamedica.entities;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "medicos")
@PrimaryKeyJoinColumn(name = "id_funcionario")
public class Medico extends Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(name = "crm_medico", nullable = false, columnDefinition = "VARCHAR(255)")
    private String crmMedico;

    @OneToOne()
    @JoinColumn(name = "id_especialidade", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "id_especialidade_medico_fk"))
    private Especialidade especialidade;


}