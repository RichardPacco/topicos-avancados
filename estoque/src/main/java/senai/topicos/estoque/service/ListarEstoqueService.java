package senai.topicos.estoque.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.estoque.domain.entity.Produto;
import senai.topicos.estoque.dto.response.ProdutoResponse;
import senai.topicos.estoque.repository.EstoqueRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarEstoqueService {

    private final EstoqueRepository repository;

    public ProdutoResponse listar(Integer id) {

        final Produto prod = repository.findById(id);

        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setData(prod.getDataCadastro());
        produtoResponse.setId(prod.getId());
        produtoResponse.setNome(prod.getNome());
        produtoResponse.setPreco(prod.getPreco());
        produtoResponse.setQuantidadeEstoque(prod.getQuantidadeEstoque());

        return produtoResponse;
    }

    public List<ProdutoResponse> listarTodos() {

        final List<Produto> listaProd = repository.findAll();

        List<ProdutoResponse> produtosResponse = new ArrayList<>();

        listaProd.forEach(produto -> {
            ProdutoResponse produtoResponse = new ProdutoResponse();
            produtoResponse.setData(produto.getDataCadastro());
            produtoResponse.setId(produto.getId());
            produtoResponse.setNome(produto.getNome());
            produtoResponse.setPreco(produto.getPreco());
            produtoResponse.setQuantidadeEstoque(produto.getQuantidadeEstoque());

            produtosResponse.add(produtoResponse);
        });

        return produtosResponse;
    }


}
