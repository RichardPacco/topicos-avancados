package senai.topicos.service.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.feign.FeignEstoqueApi;

@Service
@RequiredArgsConstructor
public class AtualizarEstoqueService {

    private final FeignEstoqueApi feignEstoqueApi;

    public Integer atualizar(Integer id, Integer qtd) {
        return feignEstoqueApi.atualizar(id, qtd);
    }
}
