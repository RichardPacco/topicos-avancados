package senai.topicos.service.compra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.domain.entity.Compra;
import senai.topicos.domain.entity.Produto;
import senai.topicos.repository.CompraRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ComprarProdutoService {

    private final CompraRepository repository;


    public Integer comprarProduto(Integer id) {


        Compra compra = new Compra();
        compra.setData(new Date());

        return repository.cadastrarCompra(compra);
    }
}
