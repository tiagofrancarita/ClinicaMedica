package br.com.franca.clinicamedica.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "internacao")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Internacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_internacao", updatable = false, unique = true, nullable = false)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_entrada", nullable = false, columnDefinition = "TIMESTAMP")
    private Date dataEntrada;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_prev_alta", nullable = true, columnDefinition = "TIMESTAMP")
    private Date dataPrevAlta;

    @Column(name = "descricao_internacao", nullable = false, columnDefinition = "VARCHAR(255)")
    private String descricaoInternacao;

    @Column(name = "caraterInternacao", nullable = false, columnDefinition = "VARCHAR(255)")
    private String caraterInternacao;

    @Column(name = "cid10", nullable = false, columnDefinition = "VARCHAR(255)")
    private String cid10;

    @Column(name = "diagnostico", nullable = false, columnDefinition = "VARCHAR(255)")
    private String diagnostico;

    @OneToOne
    @JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "id_paciente_fk_internacao"))
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "id_medico", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "id_medico_fk_internacao"))
    private Medico medico;

    @OneToOne
    @JoinColumn(name = "id_quarto", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "id_quarto_fk_internacao"))
    private Quarto quarto;


}