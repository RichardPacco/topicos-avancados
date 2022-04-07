package senai.topicos.service.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.feign.EstoqueApi;

@Service
@RequiredArgsConstructor
public class DeletarProdutoService {

    private final EstoqueApi feign;

    public void delete(Integer id) {
        feign.delete(id);
    }
}
