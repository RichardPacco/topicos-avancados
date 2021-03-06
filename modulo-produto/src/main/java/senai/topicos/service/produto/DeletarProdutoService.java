package senai.topicos.service.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.feign.FeignEstoqueApi;

@Service
@RequiredArgsConstructor
public class DeletarProdutoService {

    private final FeignEstoqueApi feign;

    public void delete(Integer id) {
        feign.delete(id);
    }
}
