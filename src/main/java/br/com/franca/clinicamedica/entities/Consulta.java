package br.com.franca.clinicamedica.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "consulta")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta", updatable = false, unique = true, nullable = false)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataConsulta", nullable = false, columnDefinition = "TIMESTAMP")
    private Date dataConsulta;

    @Column(name = "valorConsulta", nullable = false, columnDefinition = "VARCHAR(255)")
    private BigDecimal valorConsulta;

    @ManyToOne
    @JoinColumn(name = "id_convenio", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "id_convenio_fk"))
    private Convenio convenio;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "id_medico_fk"))
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "id_paciente_fk"))
    private Paciente paciente;

    @OneToOne()
    @JoinColumn(name = "id_especialidade", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "id_especialidade_fk"))
    private Especialidade especialidade;




}