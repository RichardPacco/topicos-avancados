package senai.topicos.dto.request;

import lombok.Data;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

@Data
public class ProdutoRequest {

    @NotNull(message = "{name.notnull}")
    private String nome;
//TODO Arrumar esta classe
    @NotNull(message = "{test.message}")
    private BigDecimal preco;
    private Integer quantidadeEstoque;

}
