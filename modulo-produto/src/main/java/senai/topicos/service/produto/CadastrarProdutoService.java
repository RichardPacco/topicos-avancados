package senai.topicos.service.produto;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.topicos.domain.entity.Produto;
import senai.topicos.dto.request.ProdutoDTO;
import senai.topicos.validator.ProdutoValidator;

@Service
@RequiredArgsConstructor
public class CadastrarProdutoService {

    private final ProdutoValidator validator;

    private final Map<Integer, Produto> produtoMap = new HashMap<>();
    private Integer contador = 1;

    public Integer cadastrar(final ProdutoDTO produtoDTO) {

        validator.validate(produtoDTO);

        Produto produtoEntity = new Produto();
        produtoEntity.setPreco(produtoDTO.getPreco());
        produtoEntity.setNome(produtoDTO.getNome());
        produtoEntity.setData(Date.from(Instant.now()));
        produtoEntity.setId(contador);

        produtoMap.put(produtoEntity.getId(), produtoEntity);
        contador++;

        return produtoEntity.getId();
    }
}
