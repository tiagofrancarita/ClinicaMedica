package br.com.franca.clinicamedica.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "receita")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receita", updatable = false, unique = true, nullable = false)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_receita", nullable = false, columnDefinition = "TIMESTAMP")
    private Date dataReceita;

    @Column(name = "medicamento", nullable = false, columnDefinition = "VARCHAR(255)")
    private String medicamento;

    @Column(name = "quantidade_medicamento", nullable = false, columnDefinition = "VARCHAR(255)")
    private Integer quantidadeMedicamento;

    @Column(name = "instrucao_uso", nullable = false, columnDefinition = "VARCHAR(255)")
    private String instrucaoUso;

    @OneToOne
    @JoinColumn(name = "id_consulta", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "id_consulta_fk"))
    private Consulta consulta;

}