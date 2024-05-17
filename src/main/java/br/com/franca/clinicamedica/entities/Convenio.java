package br.com.franca.clinicamedica.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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

}
