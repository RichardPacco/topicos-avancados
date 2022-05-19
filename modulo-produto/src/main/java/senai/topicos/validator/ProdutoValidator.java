package senai.topicos.validator;

import org.springframework.stereotype.Component;
import senai.topicos.dto.request.ProdutoRequest;

@Component
public class ProdutoValidator {

    public void validate(final ProdutoRequest produtoRequest) {
//TODO adicionar tratamento de Exception Handler e internacionalização
        if (produtoRequest.getQuantidadeEstoque() == null) {
            throw new RuntimeException("quantidade invalida");
        }

        if (produtoRequest.getNome() == null) {
            throw new RuntimeException("Nome Invalido");
        }

        if (produtoRequest.getPreco() == null) {
            throw new RuntimeException("Preço invalido");
        }
    }
}
