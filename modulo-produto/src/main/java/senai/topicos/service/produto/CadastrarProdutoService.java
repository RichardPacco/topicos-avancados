package senai.topicos.service.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.domain.entity.Produto;
import senai.topicos.dto.request.ProdutoRequest;
import senai.topicos.repository.ProdutoRepository;
import senai.topicos.validator.ProdutoValidator;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CadastrarProdutoService {

    private final ProdutoValidator validator;
    private final ProdutoRepository repository;

    public Integer cadastrar(final ProdutoRequest produtoRequest) {

        validator.validate(produtoRequest);

        Produto produto = new Produto();
        produto.setNome(produtoRequest.getNome());
        produto.setPreco(produtoRequest.getPreco());
        produto.setData(new Date());

        return repository.saveProduto(produto);
    }
}
