package senai.topicos.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoDTO {

    private String nome;
    private BigDecimal preco;

}
