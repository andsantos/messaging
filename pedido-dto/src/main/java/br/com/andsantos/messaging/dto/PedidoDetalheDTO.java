package br.com.andsantos.messaging.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDetalheDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private BigDecimal precoUnitario;

    private BigDecimal quantidade;

    private BigDecimal desconto;

    private PedidoDTO pedido;

    private ProdutoDTO produto;
}
