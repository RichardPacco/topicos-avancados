package senai.topicos.repository;

import org.springframework.stereotype.Component;
import senai.topicos.domain.entity.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//depois refatorar para ser uma classe extends CrudRepository e anotar com @Repository
@Component
public class ProdutoRepository {

    private final Map<Integer, Produto> produtoMap = new HashMap<>();
    private Integer contador = 1;

    public Produto findById(Integer id) {
        return produtoMap.get(id);
    }

    public List<Produto> findAll() {
        return new ArrayList<>(produtoMap.values());
    }

    public Integer save(Produto produto) {

        produto.setId(contador);

        produtoMap.put(produto.getId(), produto);
        contador++;

        return produto.getId();
    }

    public void delete(Integer id) {
        produtoMap.remove(id);
    }
}
