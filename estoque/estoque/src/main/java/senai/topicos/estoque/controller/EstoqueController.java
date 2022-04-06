package senai.topicos.estoque.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import senai.topicos.estoque.dto.request.OrdemCompraRequest;
import senai.topicos.estoque.dto.request.ProdutoRequest;
import senai.topicos.estoque.service.CadastrarProdutoService;
import senai.topicos.estoque.service.ComprarProdutoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/estoque") //TODO v1 explicar
public class EstoqueController implements EstoqueApi{

    private final ComprarProdutoService comprarProdutoService;
    private final CadastrarProdutoService cadastrarProdutoService;

    @PostMapping("cadastrar")
    public Integer cadastrarProduto(@RequestBody ProdutoRequest produtoRequest) {
        return cadastrarProdutoService.cadastrar(produtoRequest);
    }

//    @PostMapping("comprar")
//    public Integer comprarProduto(@RequestBody OrdemCompraRequest request) {
//        return comprarProdutoService.comprar(request);
//    }
}
