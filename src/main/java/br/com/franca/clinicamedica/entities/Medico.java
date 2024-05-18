package br.com.franca.clinicamedica.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "medico")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "nome_medico", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nomeMedico;

    @Column(name = "cpf_medico", nullable = false, columnDefinition = "VARCHAR(255)")
    private String cpfMedico;

    @Column(name = "crm_medico", nullable = false, columnDefinition = "VARCHAR(255)")
    private String crmMedico;

    @Column(name = "email_medico", nullable = false, columnDefinition = "VARCHAR(255)")
    private String emailMedico;

    @OneToOne()
    @JoinColumn(name = "id_especialidade", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "id_especialidade_fk"))
    private Especialidade especialidade;


}