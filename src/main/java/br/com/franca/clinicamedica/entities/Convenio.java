package br.com.franca.clinicamedica.entities;


import br.com.franca.clinicamedica.enums.StatusConvenioEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "convenio")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Convenio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prontuario", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nome;

    @OneToMany(mappedBy = "convenio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TipoPlano> tipoPlano;


    @Enumerated(EnumType.STRING)
    @Column(name = "status_conveio>", nullable = false, columnDefinition = "VARCHAR(255)")
    private StatusConvenioEnum statusConvenio;

    @Column(name = "cnpj", nullable = false, columnDefinition = "VARCHAR(255)")
    private String cnpj;

    @Column(name = "registro_ans", nullable = false, columnDefinition = "VARCHAR(255)")
    private String registroAns;

}
