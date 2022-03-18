package br.com.andsantos.messaging.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDate dataPedido;

    private LocalDate dataSolicitacao;

    private LocalDate dataEnvio;

    private BigDecimal valorFrete;

    private Set<PedidoDetalheDTO> pedidoDetalhe = new HashSet<>();

    private ClienteDTO cliente;

}
