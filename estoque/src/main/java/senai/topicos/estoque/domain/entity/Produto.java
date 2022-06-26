package senai.topicos.estoque.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "PRODUTO")
public class Produto implements Serializable {

    private static final long serialVersionUID = 6932956485923526428L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "PRECO")
    private BigDecimal preco;

    @Column(name = "QUANTIDADE_ESTOQUE")
    private Integer quantidadeEstoque;

    @PrePersist
    protected void onCreate() {
        setDataCadastro(new Date());
    }
}
