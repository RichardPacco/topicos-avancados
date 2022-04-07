package senai.topicos.service.produto;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.domain.entity.Produto;
import senai.topicos.dto.response.ProdutoResponse;
import senai.topicos.repository.ProdutoRepository;

@Service
@RequiredArgsConstructor
public class ListarProdutoService {

    private final ProdutoRepository repository;

    public ProdutoResponse listar(Integer id) {

        final Produto prod = repository.findById(id);

        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setData(prod.getData());
        produtoResponse.setId(prod.getId());
        produtoResponse.setNome(prod.getNome());
        produtoResponse.setPreco(prod.getPreco());

        return produtoResponse;
    }

    public List<ProdutoResponse> listarTodos() {

        final List<Produto> listaProd = repository.findAll();

        List<ProdutoResponse> produtosResponse = new ArrayList<>();

        listaProd.forEach(produto -> {
            ProdutoResponse produtoResponse = new ProdutoResponse();
            produtoResponse.setData(produto.getData());
            produtoResponse.setId(produto.getId());
            produtoResponse.setNome(produto.getNome());
            produtoResponse.setPreco(produto.getPreco());

            produtosResponse.add(produtoResponse);
        });

        return produtosResponse;
    }
}
