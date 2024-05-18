package br.com.franca.clinicamedica.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tipo_quarto")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoQuarto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoQuarto", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "valor_diaria", nullable = false, columnDefinition = "VARCHAR(255)")
    private BigDecimal valorDiaria;

    @Column(name = "descricao_quarto", nullable = false, columnDefinition = "VARCHAR(255)")
    private String descricaoQuarto;




}



