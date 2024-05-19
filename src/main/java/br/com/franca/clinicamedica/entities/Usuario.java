package br.com.franca.clinicamedica.entities;


import br.com.franca.clinicamedica.enums.TipoUsuarioEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, columnDefinition = "VARCHAR(255)")
    private String nome;

    @Column(name = "login", nullable = false, columnDefinition = "VARCHAR(255)")
    private String login;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(255)")
    private String email;

    @Column(name = "senha", nullable = false, columnDefinition = "VARCHAR(255)")
    private String senha;

    @Column(name = "ativo", nullable = false, columnDefinition = "VARCHAR(255)")
    private boolean ativo;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataCriacao", nullable = false, columnDefinition = "TIMESTAMP")
    private Date dataCriacao;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_atualizacao", nullable = false, columnDefinition = "TIMESTAMP")
    private Date dataAtualizacao;

    @ManyToOne(targetEntity = Funcionario.class)
    @JoinColumn(name = "id_funcionario", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "funcionario_fk"), referencedColumnName = "id_funcionario")
    private Funcionario funcionario;

    @OneToMany()
    @JoinTable(name = "usuarios_acesso", uniqueConstraints = @UniqueConstraint (columnNames = {"id_usuario", "id_acesso"},name = "unique_acesso_user"),
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", table = "usuario", unique = false, foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),
            inverseJoinColumns = @JoinColumn(name = "id_acesso", unique = false, referencedColumnName = "id_acesso", table = "acesso", foreignKey = @ForeignKey(name = "acesso_fk", value = ConstraintMode.CONSTRAINT)))
    private List<Acesso> acessos;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.acessos;
    }

    @Override
    public String getPassword() {

        return this.senha;

    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
