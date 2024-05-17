package br.com.franca.clinicamedica.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "logradouro", nullable = false, columnDefinition = "VARCHAR(255)")
    private String logradouro;

    @Column(name = "numero", nullable = false, columnDefinition = "VARCHAR(255)")
    private String numero;

    @Column(name = "complemento", nullable = false, columnDefinition = "VARCHAR(255)")
    private String complemento;

    @Column(name = "bairro", nullable = false, columnDefinition = "VARCHAR(255)")
    private String bairro;

    @Column(name = "cidade", nullable = false, columnDefinition = "VARCHAR(255)")
    private String cidade;

    @Column(name = "estado", nullable = false, columnDefinition = "VARCHAR(255)")
    private String estado;

    @Column(name = "uf", nullable = false, columnDefinition = "VARCHAR(255)")
    private String uf;

    @Column(name = "cep", nullable = false, columnDefinition = "VARCHAR(255)")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}
