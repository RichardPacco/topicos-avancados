package senai.topicos.estoque.repository;

import org.springframework.stereotype.Component;
import senai.topicos.estoque.domain.entity.Produto;

import java.util.HashMap;
import java.util.Map;

@Component
public class EstoqueRepository {

    private final Map<Integer, Produto> estoqueMap = new HashMap<>();
    private Integer contador = 1;

//    public Produto findById(Integer id) {
//
//        estoqueMap.get()
//        return estoqueMap.get(id);
//    }

    public Integer saveProduto(Produto produto) {

        produto.setId(contador);

        estoqueMap.put(produto.getId(), produto);
        contador++;

        return produto.getId();
    }
}
