package br.com.franca.clinicamedica.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tipo_plano")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoPlano implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_plano", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "nome_plano", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nome;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inicio", nullable = false, columnDefinition = "TIMESTAMP")
    private Date dataInicio;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_fim", nullable = false, columnDefinition = "TIMESTAMP")
    private Date dataFim;

    @ManyToOne
    @JoinColumn(name = "convenio_id")
    private Convenio convenio;
}
