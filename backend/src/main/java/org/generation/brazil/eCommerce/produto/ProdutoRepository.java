package org.generation.brazil.eCommerce.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNome(String nome);

    List<Produto> findByValorLessThan(BigDecimal valor);

    List<Produto> findByValorGreaterThan(BigDecimal valor);

    List<Produto> findByValorBetween(BigDecimal minimo, BigDecimal maximo);

    Optional<Produto> findById(Long Id);

    @Modifying
    @Transactional
    @Query("UPDATE Produto p SET p.valor = :valor WHERE p.id = :id")
    void updateValorById(@Param("valor") BigDecimal valor, @Param("id") Long id);

    @Modifying
    @Transactional
    void deleteByValorLessThan(BigDecimal valor);
}

