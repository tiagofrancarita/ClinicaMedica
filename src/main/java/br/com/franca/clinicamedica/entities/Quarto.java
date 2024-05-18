package br.com.franca.clinicamedica.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "quarto")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quarto implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_quarto", updatable = false, unique = true, nullable = false)
        private Long id;

        @Column(name = "numero_quarto", nullable = false, columnDefinition = "VARCHAR(255)")
        private String numero;

        @ManyToOne
        @JoinColumn(name = "id_ala", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "id_ala_fk"))
        private Ala ala;

        @OneToOne
        @JoinColumn(name = "id_tipo_quarto", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "id_tipo_quarto_fk"))
        private TipoQuarto tipoQuarto;
}