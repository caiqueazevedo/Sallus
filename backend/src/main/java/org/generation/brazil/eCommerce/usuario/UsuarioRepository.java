package org.generation.brazil.eCommerce.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // SELECT * FROM usuario WHERE nome = :nome;
    List<Usuario> findByNome(String nome);

    // SELECT * FROM usuario WHERE data_nascimento = :dataNascimento;
    List<Usuario> findByDataNascimento(LocalDate dataNascimento);

    // SELECT * FROM usuario WHERE nome = :nome AND data_nascimento = :dataNascimento;
    List<Usuario> findByNomeAndDataNascimento(String nome, LocalDate dataNascimento);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario c SET c.nome = :nome WHERE c.id = :id")
    void updateNomeById(@Param("nome") String nome, @Param("id") Long id);

    @Modifying
    @Transactional
    void deleteByDataNascimentoAndNome(LocalDate dataNascimento, String nome);
}

