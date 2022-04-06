package senai.topicos.dto.response;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class ProdutoResponse {

    private Integer id;
    private Date data;
    private String nome;
    private BigDecimal preco;
    private Integer quantidadeEstoque;


}
