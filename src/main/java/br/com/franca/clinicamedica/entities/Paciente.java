package br.com.franca.clinicamedica.entities;

import br.com.franca.clinicamedica.enums.CorRacaEnum;
import br.com.franca.clinicamedica.enums.EstadoCivilEnum;
import br.com.franca.clinicamedica.enums.FormaPagamentoEnum;
import br.com.franca.clinicamedica.enums.SexoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "paciente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "numero_prontuario", nullable = false, columnDefinition = "VARCHAR(255)")
    private String numeroProntuario;

    @Column(name = "nome_completo", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nomeCompleto;

    @Column(name = "cpf", nullable = false, columnDefinition = "VARCHAR(255)")
    private String cpf;

    @Column(name = "registro_geral", nullable = false, columnDefinition = "VARCHAR(255)")
    private String rg;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_nascimento", nullable = false, columnDefinition = "TIMESTAMP")
    private Date dataNascimento;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_entrada", nullable = false, columnDefinition = "TIMESTAMP")
    private Date dataEntrada;

    @Column(name = "nome_mae", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nomeMae;

    @Column(name = "nome_pai", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nomePai;

    @ManyToOne
    @JoinColumn(name = "id_convenio",  nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "convenio_id_fk"))
    private Convenio convenio;

    @Column(name = "numero_carteira_convenio", nullable = false, columnDefinition = "VARCHAR(255)")
    private String numeroCarteiraConvenio;

    @Column(name = "plano", nullable = false, columnDefinition = "VARCHAR(255)")
    private String Plano;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_validade_plano", nullable = false, columnDefinition = "TIMESTAMP")
    private Date validadePlano;

    @OneToOne
    @JoinColumn(name = "id_prontuario",  nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "prontuario_id_fk"))
    private Prontuario prontuario;

    @OneToMany(mappedBy = "paciente", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    @Column(name = "altura", nullable = false, columnDefinition = "VARCHAR(255)")
    private Integer altura;

    @Column(name = "peso", nullable = false, columnDefinition = "VARCHAR(255)")
    private Integer peso;

    @Enumerated(EnumType.STRING)
    @Column(name = "estadoCivil", nullable = false, columnDefinition = "VARCHAR(255)")
    private EstadoCivilEnum estadoCivilEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "corRaca", nullable = false, columnDefinition = "VARCHAR(255)")
    private CorRacaEnum corRacaEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false, columnDefinition = "VARCHAR(255)")
    private SexoEnum sexoEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "formaPagamento", nullable = false, columnDefinition = "VARCHAR(255)")
    private FormaPagamentoEnum formaPagamentoEnum;

}