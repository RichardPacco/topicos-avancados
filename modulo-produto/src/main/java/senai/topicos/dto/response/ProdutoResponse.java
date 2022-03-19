package senai.topicos.dto.response;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class ProdutoResponse {

    public Integer id;
    public Date data;
    public String nome;
    public BigDecimal preco;


}
