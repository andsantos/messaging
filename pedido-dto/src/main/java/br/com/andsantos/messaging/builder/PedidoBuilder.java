package br.com.andsantos.messaging.builder;

import java.util.HashSet;
import java.util.Set;

import br.com.andsantos.messaging.dto.ClienteDTO;
import br.com.andsantos.messaging.dto.PedidoDTO;
import br.com.andsantos.messaging.dto.PedidoDetalheDTO;

public class PedidoBuilder {
    private ClienteDTO cliente;
    private Set<PedidoDetalheDTO> pedidoDetalhe = new HashSet<>();

    private PedidoBuilder() { }

    public static PedidoBuilder builder() {
        return new PedidoBuilder();
    }

    public PedidoBuilder cliente(ClienteDTO dto) {
        this.cliente = dto;
        return this;
    }

    public PedidoBuilder item(PedidoDetalheDTO dto) {
        this.pedidoDetalhe.add(dto);
        return this;
    }

    public PedidoDTO build() {
        PedidoDTO pedido = new PedidoDTO();

        if (this.cliente == null) {
            throw new BuilderException("Cliente não informado.");
        }

        if (this.pedidoDetalhe.size() == 0) {
            throw new BuilderException("Nenhum item da compra foi informado.");
        }

        pedido.setCliente(cliente);
        pedido.setPedidoDetalhe(pedidoDetalhe);

        return pedido;
    }
}
