package senai.topicos.estoque.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.estoque.domain.entity.Compra;
import senai.topicos.estoque.repository.CompraRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarComprasService {

    private final CompraRepository repository;

    public List<Compra> listar() {
        return repository.findAll();
    }

    public List<Compra> listarComprasEspecificas() {

        List<Compra> comprasAcima10 = new ArrayList<>();
        List<Compra> compras = repository.findAll();

        BigDecimal valorComparar = new BigDecimal(10);
        compras.forEach(compra -> {
            if (compra.getValorTotal().compareTo(valorComparar) == 1) {
                comprasAcima10.add(compra);
            }
        });
        return comprasAcima10;
    }
}
