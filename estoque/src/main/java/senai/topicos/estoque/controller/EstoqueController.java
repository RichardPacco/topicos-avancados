package senai.topicos.estoque.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import senai.topicos.estoque.dot.response.ProdutoResponse;
import senai.topicos.estoque.dto.request.OrdemCompraRequest;
import senai.topicos.estoque.dto.request.ProdutoRequest;
import senai.topicos.estoque.service.CadastrarProdutoService;
import senai.topicos.estoque.service.ComprarProdutoService;
import senai.topicos.estoque.service.DeletarEstoqueService;
import senai.topicos.estoque.service.ListarEstoqueService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/estoque") //TODO v1 explicar
public class EstoqueController implements EstoqueApi{

    private final ComprarProdutoService comprarProdutoService;
    private final CadastrarProdutoService cadastrarProdutoService;
    private final ListarEstoqueService listarEstoqueService;
    private final DeletarEstoqueService deletarEstoqueService;

    @PostMapping("cadastrar")
    public Integer cadastrarProduto(@RequestBody ProdutoRequest produtoRequest) {
        return cadastrarProdutoService.cadastrar(produtoRequest);
    }

    @GetMapping("listrar")
    public List<ProdutoResponse> listarTodos() {
        return listarEstoqueService.listarTodos();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        deletarEstoqueService.delete(id);
    }

    @GetMapping("{id}")
    public ProdutoResponse listarEstoque(@PathVariable("id") Integer id) {
        return listarEstoqueService.listar(id);
    }

}
