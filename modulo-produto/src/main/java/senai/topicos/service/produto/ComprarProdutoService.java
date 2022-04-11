package senai.topicos.service.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.feign.FeignEstoqueApi;

@RequiredArgsConstructor
@Service
public class ComprarProdutoService {

    private final FeignEstoqueApi feignEstoqueApi;

    public Boolean comprar(Integer id, Integer qtd) {

        return feignEstoqueApi.comprar(id, qtd);

    }
}
