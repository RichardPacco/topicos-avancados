package senai.topicos.estoque.repository;

import org.springframework.stereotype.Component;
import senai.topicos.estoque.domain.entity.Compra;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompraRepository {
    //TODO Alterar para crud repository quando tiver DB
    private final List<Compra> compras = new ArrayList<>();

    public List<Compra> listarCompras() {
        return compras;
    }

    public void add(Compra compra) {
        compras.add(compra);
    }


}
