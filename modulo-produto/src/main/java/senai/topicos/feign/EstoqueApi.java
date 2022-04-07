package senai.topicos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import senai.topicos.dto.request.ProdutoRequest;
import senai.topicos.dto.response.ProdutoResponse;

import java.util.List;

@FeignClient(name = "estoque", url ="${feign.url.estoque}")
public interface EstoqueApi {


    @PostMapping("cadastrar")
    Integer cadastrarProduto(@RequestBody ProdutoRequest produtoRequest);

    @GetMapping("listrar")
    List<ProdutoResponse> listarTodos();

    @DeleteMapping("{id}")
    void delete(@PathVariable("id")Integer id);

    @GetMapping("{id}")
    ProdutoResponse listarEstoque(@PathVariable("id") Integer id);

}
