package senai.topicos.service.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.dto.request.ProdutoRequest;
import senai.topicos.feign.FeignEstoqueApi;
import senai.topicos.validator.ProdutoValidator;

@Service
@RequiredArgsConstructor
public class CadastrarProdutoService {

    private final ProdutoValidator validator;
    private final FeignEstoqueApi feign;

    public Integer cadastrar(final ProdutoRequest produtoRequest) {

        validator.validate(produtoRequest);

        return feign.cadastrarProduto(produtoRequest);
    }
}
