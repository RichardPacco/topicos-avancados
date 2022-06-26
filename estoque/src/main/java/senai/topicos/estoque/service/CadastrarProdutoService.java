package senai.topicos.estoque.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.estoque.domain.entity.Produto;
import senai.topicos.estoque.dto.request.ProdutoRequest;
import senai.topicos.estoque.repository.EstoqueRepository;

@Service
@RequiredArgsConstructor
public class CadastrarProdutoService {

    private final EstoqueRepository repository;

    public Integer cadastrar(final ProdutoRequest produtoRequest) {

        Produto produto = new Produto();
        produto.setNome(produtoRequest.getNome());
        produto.setPreco(produtoRequest.getPreco());
        produto.setQuantidadeEstoque(produtoRequest.getQuantidadeEstoque());
        repository.save(produto);

        return produto.getId();
    }
}
