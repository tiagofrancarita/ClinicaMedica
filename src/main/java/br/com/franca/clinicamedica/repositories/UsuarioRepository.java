package br.com.franca.clinicamedica.repositories;

import br.com.franca.clinicamedica.entities.Funcionario;
import br.com.franca.clinicamedica.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long userId);

    List<Usuario> findByFuncionario(Funcionario funcionario);

    @Query(nativeQuery = true,value = "SELECT constraint_name FROM information_schema.constraint_column_usage WHERE table_name = 'usuarios_acesso' AND column_name = 'acesso_id' AND constraint_name <> 'unique_acesso_user' ")
    String consultaConstraintAcesso();

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO usuarios_acesso (id_usuario, id_acesso) VALUES (?1,(SELECT id_acesso FROM acesso WHERE descricao_acesso='ROLE_MEDICO'))")
    void cadastroAcessoMedico(Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO usuarios_acesso (id_usuario, id_acesso) VALUES (?1,(SELECT id_acesso FROM acesso WHERE descricao_acesso='ROLE_ENFERMEIRO'))")
    void cadastroAcessoEnfermeiro(Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO usuarios_acesso (id_usuario, id_acesso) VALUES (?1,(SELECT id_acesso FROM acesso WHERE descricao_acesso='ROLE_ADMIN'))")
    void cadastroAcessoAdmin(Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO usuarios_acesso (id_usuario, id_acesso) VALUES (?1,(SELECT id_acesso FROM acesso WHERE descricao_acesso='ROLE_USER'))")
    void cadastroAcessoPaciente(Long id);

    Usuario findByFuncionarioId(Long id);
}
