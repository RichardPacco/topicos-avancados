package senai.topicos.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoRequest {

    private String nome;
    private BigDecimal preco;
    private Integer quantidadeEstoque;

}
