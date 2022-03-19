package senai.topicos.validator;

import org.springframework.stereotype.Component;

import senai.topicos.dto.request.ProdutoDTO;

@Component
public class ProdutoValidator {

    public void validate(final ProdutoDTO produtoDTO) {

        if (produtoDTO.getNome() == null) {
            throw new RuntimeException("Nome Invalido");
        }

        if (produtoDTO.getPreco() == null) {
            throw new RuntimeException("Preço invalido");
        }
    }
}
