package org.generation.brazil.eCommerce.produto;

import org.generation.brazil.eCommerce.produto.Produto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.math.BigDecimal;
import java.util.List;

public interface PaginationRepository extends PagingAndSortingRepository<Produto, Long> {
    List<Produto> findAllByNome(String name, Pageable pageable);
    List<Produto> findAllByValor(BigDecimal valor, Pageable pageable);
    List<Produto> findAllById(Long id, Pageable pageable);

    //?sort=name_asc


}
