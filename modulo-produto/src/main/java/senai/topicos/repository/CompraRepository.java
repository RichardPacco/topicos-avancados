package senai.topicos.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import senai.topicos.domain.entity.Compra;
import senai.topicos.domain.entity.Produto;

@Component
@RequiredArgsConstructor
public class CompraRepository {

    private final ProdutoRepository repository;

    public Integer cadastrarCompra(Compra compra) {

        final Produto produto = repository.findById(compra.getProduto().getId());
        
        compra.setId(contador);
        compraMap.put(compra.getId(), compra);
        contador++;

        return compra.getId();
    }

}
