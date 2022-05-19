package senai.topicos.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import senai.topicos.domain.entity.Compra;
import senai.topicos.dto.request.ProdutoRequest;
import senai.topicos.dto.response.ProdutoResponse;

import java.util.List;

@FeignClient(name = "feignEstoqueApi", url = "${feign.url.estoque}")
public interface FeignEstoqueApi {


    @PostMapping("cadastrar")
    Integer cadastrarProduto(@RequestBody ProdutoRequest produtoRequest);

    @GetMapping("listrar")
    List<ProdutoResponse> listarTodos();

    @DeleteMapping("{id}")
    void delete(@PathVariable("id") Integer id);

    @GetMapping("{id}")
    ProdutoResponse listarEstoque(@PathVariable("id") Integer id);

    @PutMapping("comprar/{id}/{qtd}")
    Boolean comprar(@PathVariable("id") Integer id,
                    @PathVariable("qtd") Integer qtd);

    @GetMapping("verificar/{id}/{qtd}")
    Boolean verificar(@PathVariable("id") Integer id,
                      @PathVariable("qtd") Integer qtd);

    @GetMapping("listarCompras")
    List<Compra> listarCompras();

    @PutMapping("atualizar/{id}/{qtd}")
    Integer atualizar(@PathVariable("id") Integer id, @PathVariable("qtd") Integer qtd);

    @PostMapping("loteCompras")
    void gerarLoteCompras();

}

