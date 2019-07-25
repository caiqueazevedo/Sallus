package org.generation.brazil.eCommerce.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // SELECT * FROM cliente WHERE nome = :nome;
    List<Cliente> findByNome(String nome);

    // SELECT * FROM cliente WHERE data_nascimento = :dataNascimento;
    List<Cliente> findByDataNascimento(LocalDate dataNascimento);

    // SELECT * FROM cliente WHERE nome = :nome AND data_nascimento = :dataNascimento;
    List<Cliente> findByNomeAndDataNascimento(String nome, LocalDate dataNascimento);

    @Modifying
    @Transactional
    @Query("UPDATE Cliente c SET c.nome = :nome WHERE c.id = :id")
    void updateNomeById(@Param("nome") String nome, @Param("id") Long id);

    @Modifying
    @Transactional
    void deleteByDataNascimentoAndNome(LocalDate dataNascimento, String nome);
}

