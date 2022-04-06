package senai.topicos.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
//TODO Adicionar entity quando tiver banco de dados
public class Produto {

    private Integer id;
    private Date data;
    private String nome;
    private BigDecimal preco;
    private Integer quantidadeEstoque;

}
