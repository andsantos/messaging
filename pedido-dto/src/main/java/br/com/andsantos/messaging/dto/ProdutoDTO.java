package br.com.andsantos.messaging.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nomeProduto;

    private String quantidadePorUnidade;

    private BigDecimal precoUnitario;

    private Long unidadesEmEstoque;

    private Boolean descontinuado;

    private Long fornecedorId;

    private String nomeFornecedor;

    private Long categoriaId;

    private String nomeCategoria;
}
