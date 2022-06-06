package senai.topicos.estoque.batch.items;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import senai.topicos.estoque.domain.entity.Compra;
import senai.topicos.estoque.repository.CompraRepository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;

public class CompraReader implements ItemReader<Compra> {


    File file = new File("LoteComprasOld.txt");

    @Autowired
    private CompraRepository compraRepository;
    private Iterator<Compra> it;
    private Compra compraRetorno;

    @PostConstruct
    public void postConstruct() throws IOException {
        File file2 = new File("LoteCompras.txt");
        if (file2.exists()) {
            Files.copy(file2.toPath(), Paths.get("LoteComprasBackup.txt"), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    @Override
    public Compra read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("Reader");

        if (compraRetorno == null) {
            it = compraRepository.listarCompras().iterator();
        }

        while (it.hasNext()) {
            return compraRetorno = it.next();
        }
        compraRetorno = null;
        Files.copy(file.toPath(), Paths.get("LoteCompras.txt"), StandardCopyOption.REPLACE_EXISTING);
        file.delete();
        return compraRetorno;
    }
}