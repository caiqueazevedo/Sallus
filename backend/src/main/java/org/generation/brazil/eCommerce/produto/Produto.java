package org.generation.brazil.eCommerce.produto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @NotNull
    @Column(name = "valor_unidade")
    private BigDecimal valor;

    @NotNull
    @Column(name = "nome_produto")
    private String nome;

    //@NotNull
    private String descricao;
}
