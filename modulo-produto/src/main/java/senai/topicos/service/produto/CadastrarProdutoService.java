package senai.topicos.service.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.dto.request.ProdutoRequest;
import senai.topicos.feign.EstoqueApi;
import senai.topicos.repository.ProdutoRepository;
import senai.topicos.validator.ProdutoValidator;

@Service
@RequiredArgsConstructor
public class CadastrarProdutoService {

    private final ProdutoValidator validator;
    private final ProdutoRepository repository;
    private final EstoqueApi feign;

    public Integer cadastrar(final ProdutoRequest produtoRequest) {

        validator.validate(produtoRequest);

        return feign.cadastrarProduto(produtoRequest);

    }
}
