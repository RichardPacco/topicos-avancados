package senai.topicos.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import senai.topicos.dto.request.ProdutoRequest;
import senai.topicos.exception.GenericException;
import senai.topicos.util.MessageProvider;

@Component
public class ProdutoValidator {

    @Autowired
    public MessageProvider msgpvd;

    public void validate(final ProdutoRequest produtoRequest) {

        if (produtoRequest.getQuantidadeEstoque() == null) {
            throw new GenericException(msgpvd.getMessage("produto.quantidade.invalido"), HttpStatus.BAD_REQUEST);
        }

        if (produtoRequest.getNome() == null) {
            throw new GenericException(msgpvd.getMessage("produto.nome.invalido"), HttpStatus.BAD_REQUEST);
        }

        if (produtoRequest.getPreco() == null) {
            throw new GenericException(msgpvd.getMessage("produto.preco.invalido"), HttpStatus.BAD_REQUEST);
        }
    }
}
