package br.com.franca.clinicamedica.entities;

import br.com.franca.clinicamedica.enums.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_funcionario", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nomeCompleto;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuarioEnum tipoUsuarioEnum;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_contratacao", nullable = false, columnDefinition = "TIMESTAMP")
    private Date dataContratacao;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_nascimento", nullable = false, columnDefinition = "TIMESTAMP")
    private Date dataNascimento;

    @Column(name = "cpf", nullable = false, columnDefinition = "VARCHAR(255)")
    private String cpf;

    @Column(name = "rg", nullable = false, columnDefinition = "VARCHAR(255)")
    private String rg;

    @Column(name = "orgao_expeditor", nullable = false, columnDefinition = "VARCHAR(255)")
    private String orgaoExpeditor;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_validade_rg", nullable = false, columnDefinition = "TIMESTAMP")
    private Date dataValidadeRG;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(255)")
    private String email;

    @Column(name = "telefone01", nullable = false, columnDefinition = "VARCHAR(255)")
    private String telefone01;

    @Column(name = "telefone02", nullable = true, columnDefinition = "VARCHAR(255)")
    private String telefone02;

    @Column(name = "telefone03", nullable = true, columnDefinition = "VARCHAR(255)")
    private String telefone03;

    @Column(name = "codigo_registro", nullable = false, columnDefinition = "VARCHAR(255)")
    private String codigoRegistro;

    @Column(name = "numero_carteira_trabalho", nullable = false, columnDefinition = "VARCHAR(255)")
    private String numeroCarteiraTrabalho;

    @Column(name = "pis_pasep", nullable = false, columnDefinition = "VARCHAR(255)")
    private String pisPasep;

    @Column(name = "numero_carteira_habilitacao", nullable = true, columnDefinition = "VARCHAR(255)")
    private String numeroCarteiraHabilitacao;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_validade_habilitacao", nullable = true, columnDefinition = "TIMESTAMP")
    private Date dataValidadeHabilitacao;

    @OneToMany(mappedBy = "funcionario", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false, columnDefinition = "VARCHAR(255)")
    private SexoEnum sexoEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "estadoCivil", nullable = false, columnDefinition = "VARCHAR(255)")
    private EstadoCivilEnum estadoCivilEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "corRaca", nullable = false, columnDefinition = "VARCHAR(255)")
    private CorRacaEnum corRacaEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_funcionario>", nullable = false, columnDefinition = "VARCHAR(255)")
    private StatusFuncionarioEnum statusFuncionarioEnum;

}
