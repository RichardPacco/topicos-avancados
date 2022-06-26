package senai.topicos.estoque.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name= "COMPRA")
public class Compra implements Serializable {

    private static final long serialVersionUID = 6677139462227727898L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="NOME_PRODUTO")
    private String nomeProduto;

    @Column(name= "QUANTIDADE")
    private Integer quantidade;

    @Column(name= "VALOR_TOTAL")
    private BigDecimal valorTotal;

    @Column(name= "DATA_VENDA")
    private Date dataVenda;

    @Column(name= "PRECO_UNIDADE")
    private BigDecimal precoUnidade;

    @PrePersist
    protected void onCreate() {
        setDataVenda(new Date());
    }

}
