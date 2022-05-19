package senai.topicos.estoque.batch.items;

import org.springframework.batch.item.ItemProcessor;
import senai.topicos.estoque.domain.entity.Compra;

import java.math.BigDecimal;

public class CompraProcessor
        implements ItemProcessor<Compra, Compra> {

    @Override
    public Compra process(Compra item) throws Exception {
        System.out.println("Processor " + item);
        if (item.getPrecoUnidade().compareTo(BigDecimal.valueOf(10)) >= 0) {
            return item;
        } else {
            return null;
        }
    }
}