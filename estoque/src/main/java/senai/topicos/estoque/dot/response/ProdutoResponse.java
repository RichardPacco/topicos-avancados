package senai.topicos.estoque.dot.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProdutoResponse {

    private Integer id;
    private Date data;
    private String nome;
    private BigDecimal preco;
    private Integer quantidadeEstoque;

}
