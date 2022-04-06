package senai.topicos.estoque.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
//TODO Adicionar entity quando tiver banco de dados
public class Produto {

    private Integer id;
    private Date data;
    private String nome;
    private BigDecimal preco;
    private Integer quantidadeEstoque;

    @Override
    public String toString() {
        return "Produto [id = " + id + ", data = " + data + ", nome = " + nome + ", preco = " + preco + "]";
    }

}
