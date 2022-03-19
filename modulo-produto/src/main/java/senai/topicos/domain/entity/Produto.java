package senai.topicos.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
//TODO Adicionar entity quando tiver banco de dados
public class Produto {

    public Integer id;
    public Date data;
    public String nome;
    public BigDecimal preco;

    @Override
    public String toString() {
        return "Produto [id = " + id + ", data = " + data + ", nome = " + nome + ", preco = " + preco + "]";
    }

}
