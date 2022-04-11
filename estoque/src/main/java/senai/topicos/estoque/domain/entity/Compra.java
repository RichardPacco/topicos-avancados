package senai.topicos.estoque.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Compra {

    private String nomeProduto;
    private Integer quantidade;
    private BigDecimal valorTotal;
    private Date dataVenda;

}
