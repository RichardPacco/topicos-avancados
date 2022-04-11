package senai.topicos.service.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.domain.entity.Compra;
import senai.topicos.feign.FeignEstoqueApi;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarComprasService {

    private final FeignEstoqueApi feignEstoqueApi;

    public List<Compra> listarCompras(){
        return feignEstoqueApi.listarCompras();
    }

}
