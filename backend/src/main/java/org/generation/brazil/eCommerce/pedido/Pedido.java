package org.generation.brazil.eCommerce.pedido;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
@Table(name = "pedido")
public class Pedido{

    @Id
    private Long idPedido;

    @NotNull
    @Column(name = "data_pedido")
    private Date dataPedido;

    @NotNull
    @Column(name = "valor_pedido")
    private BigDecimal valorPedido;

}