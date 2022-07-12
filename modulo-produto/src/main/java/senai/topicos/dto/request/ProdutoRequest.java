package senai.topicos.dto.request;

import lombok.Data;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

@Data
public class ProdutoRequest {

    @NotNull(message = "{name.not.null}")
    private String nome;

    @NotNull(message = "{preco.not.null}")
    private BigDecimal preco;

    @NotNull(message = "{quantidade.estoque.not.null}")
    private Integer quantidadeEstoque;

}
