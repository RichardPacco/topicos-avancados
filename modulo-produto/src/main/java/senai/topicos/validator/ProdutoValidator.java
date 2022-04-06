package senai.topicos.validator;

import org.springframework.stereotype.Component;

import senai.topicos.dto.request.ProdutoRequest;

@Component
public class ProdutoValidator {

    public void validate(final ProdutoRequest produtoRequest) {

        if (produtoRequest.getNome() == null) {
            throw new RuntimeException("Nome Invalido");
        }

        if (produtoRequest.getPreco() == null) {
            throw new RuntimeException("Preço invalido");
        }
    }
}
