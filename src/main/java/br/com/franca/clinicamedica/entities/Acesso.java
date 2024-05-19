package br.com.franca.clinicamedica.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Entity
@Table(name = "acesso")
@Data
public class Acesso implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acesso", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "descricao_acesso", nullable = false)
    private String descAcesso;

    @JsonIgnore
    @Override
    public String getAuthority() {
        return this.descAcesso;
    }
}
