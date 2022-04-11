package senai.topicos.service.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.feign.FeignEstoqueApi;

@Service
@RequiredArgsConstructor
public class GeraLoteService {

    private final FeignEstoqueApi feignEstoqueApi;

    public void geraLoteCompras(){
        feignEstoqueApi.gerarLoteCompras();
    }
}
