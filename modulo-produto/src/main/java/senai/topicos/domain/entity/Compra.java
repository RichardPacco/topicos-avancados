package senai.topicos.domain.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Compra {

    public Produto produto;
    public Integer id;
    public Date data;

}
