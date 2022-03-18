package br.com.andsantos.messaging.builder;

import java.math.BigDecimal;

import br.com.andsantos.messaging.dto.PedidoDetalheDTO;
import br.com.andsantos.messaging.dto.ProdutoDTO;

public class PedidoDetalheBuilder {
    private BigDecimal precoUnitario;
    private BigDecimal quantidade;
    private BigDecimal desconto;
    private ProdutoDTO produto;

    private PedidoDetalheBuilder() { }

    public static PedidoDetalheBuilder builder() {
        return new PedidoDetalheBuilder();
    }

    public PedidoDetalheBuilder precoUnitario(BigDecimal valor) {
        this.precoUnitario = valor;
        return this;
    }

    public PedidoDetalheBuilder quantidade(BigDecimal valor) {
        this.quantidade = valor;
        return this;
    }

    public PedidoDetalheBuilder desconto(BigDecimal valor) {
        this.desconto = valor;
        return this;
    }

    public PedidoDetalheBuilder produto(String valor) {
        this.produto = new ProdutoDTO();
        produto.setNomeProduto(valor);
        return this;
    }

    public PedidoDetalheDTO build() {
        PedidoDetalheDTO detalhe = new PedidoDetalheDTO();

        if (this.produto == null) {
            throw new BuilderException("Produto não informado.");
        }

        if (this.quantidade == null) {
            throw new BuilderException("Quantidade não informada.");
        }

        if (this.precoUnitario == null) {
            throw new BuilderException("Preço unitário não informado.");
        }

        detalhe.setProduto(produto);
        detalhe.setPrecoUnitario(precoUnitario);
        detalhe.setQuantidade(quantidade);
        detalhe.setDesconto(desconto);

        return detalhe;
    }
}
