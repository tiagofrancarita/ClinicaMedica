package br.com.franca.clinicamedica.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "id_funcionario")
public class Admin extends Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(name = "cargo", nullable = false, columnDefinition = "VARCHAR(255)")
    private String cargo;


}
