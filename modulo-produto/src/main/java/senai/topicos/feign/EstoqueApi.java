package senai.topicos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import senai.topicos.dto.request.ProdutoRequest;

@FeignClient(name = "estoque", url ="${feign.url.estoque}")
public interface EstoqueApi {


    @PostMapping("cadastrar")
    Integer cadastrarProduto(@RequestBody ProdutoRequest produtoRequest);

}
