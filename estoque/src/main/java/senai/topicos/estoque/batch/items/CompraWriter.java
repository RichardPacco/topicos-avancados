package senai.topicos.estoque.batch.items;

import org.springframework.batch.item.ItemWriter;
import senai.topicos.estoque.domain.entity.Compra;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.List;

public class CompraWriter implements ItemWriter<Compra> {

    String fileName = "LoteComprasOld.txt";
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void write(List<? extends Compra> items) throws Exception {
        System.out.println("Write");

        for (Compra compra : items) {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String formatedDate = sdf.format(compra.getDataVenda());
            String conteudo = "Produto: " + compra.getNomeProduto() + ", Valor total :" + compra.getValorTotal() + ", Valor Unitario :" + compra.getPrecoUnidade() + ", QTD: " + compra.getQuantidade() + ", Data: " + formatedDate;
            bw.write(conteudo);
            bw.newLine();
            bw.close();
        }
    }
}
