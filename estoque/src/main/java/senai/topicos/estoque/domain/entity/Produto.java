package senai.topicos.estoque.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
//TODO Adicionar entity quando tiver banco de dados
public class Produto {

    private Integer id;
    private Date dataCadastro;
    private String nome;
    private BigDecimal preco;
    private Integer quantidadeEstoque;

    
}
