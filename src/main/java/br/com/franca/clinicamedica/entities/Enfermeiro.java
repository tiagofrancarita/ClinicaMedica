package br.com.franca.clinicamedica.entities;


import jakarta.persistence.*;


import java.io.Serializable;

@Entity
@Table(name = "enfermeiros")
@PrimaryKeyJoinColumn(name = "id_funcionario")
public class Enfermeiro extends Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(name = "cre_enfermeiro", nullable = false, columnDefinition = "VARCHAR(255)")
    private String creEnfermeiro;

}
