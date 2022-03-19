package senai.topicos.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import senai.topicos.dto.request.ProdutoDTO;
import senai.topicos.dto.response.ProdutoResponse;
import senai.topicos.service.produto.CadastrarProdutoService;
import senai.topicos.service.produto.DeletarProdutoService;
import senai.topicos.service.produto.ListarProdutoService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/produto") //TODO v1 explicar
public class ProdutoController implements ProdutoControllerApi {

    private final CadastrarProdutoService cadastrarProdutoService;
    private final ListarProdutoService listarProdutoService;
    private final DeletarProdutoService deletarProdutoService;

    @GetMapping("listrar")
    public List<ProdutoResponse> listarTodos() {
        return listarProdutoService.listarTodos();
    }

    @DeleteMapping("{id}")
    public void delete(Integer id) {
        deletarProdutoService.delete(id);
    }

    @GetMapping("{id}")
    public ProdutoResponse listarProduto(@PathVariable("id") Integer id) {
        return listarProdutoService.listar(id);
    }

    @PostMapping("cadastrar")
    public Integer cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return cadastrarProdutoService.cadastrar(produtoDTO);
    }
}

