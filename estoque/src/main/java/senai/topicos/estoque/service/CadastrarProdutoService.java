package senai.topicos.estoque.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.estoque.domain.entity.Produto;
import senai.topicos.estoque.dto.request.ProdutoRequest;
import senai.topicos.estoque.repository.EstoqueRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CadastrarProdutoService {

    private final EstoqueRepository repository;
    private Integer contador = 1;

    public Integer cadastrar(final ProdutoRequest produtoRequest) {
//TODO criar mapper
        //TODO formatar as datas onde necessário
        Produto produto = new Produto();
        produto.setNome(produtoRequest.getNome());
        produto.setPreco(produtoRequest.getPreco());
        produto.setDataCadastro(new Date());
        produto.setQuantidadeEstoque(produtoRequest.getQuantidadeEstoque());
        produto.setId(contador);
        contador++;

        return repository.saveProduto(produto);
    }
}
