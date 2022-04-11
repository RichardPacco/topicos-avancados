package senai.topicos.service.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.feign.FeignEstoqueApi;

@Service
@RequiredArgsConstructor
public class VerificarEstoqueService {

    private final FeignEstoqueApi feignEstoqueApi;

    public Boolean verificar(Integer id, Integer qtd) {
        return feignEstoqueApi.verificar(id, qtd);
    }
}