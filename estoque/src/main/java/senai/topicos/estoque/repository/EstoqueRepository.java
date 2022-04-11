package senai.topicos.estoque.repository;

import org.springframework.stereotype.Component;
import senai.topicos.estoque.domain.entity.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EstoqueRepository {

    private final Map<Integer, Produto> estoqueMap = new HashMap<>();
    private Integer contador = 1;

    public Integer saveProduto(Produto produto) {

        estoqueMap.put(produto.getId(), produto);

        return produto.getId();
    }

    public Produto findById(Integer id) {
        return estoqueMap.get(id);
    }

    public List<Produto> findAll() {
        return new ArrayList<>(estoqueMap.values());
    }

    public void delete(Integer id) {
        estoqueMap.remove(id);
    }
}
