package senai.topicos.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import senai.topicos.domain.entity.Compra;
import senai.topicos.dto.request.ProdutoRequest;
import senai.topicos.dto.response.ProdutoResponse;
import senai.topicos.service.produto.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/produto") //TODO v1 explicar
public class ProdutoController implements ProdutoControllerApi {

    private final CadastrarProdutoService cadastrarProdutoService;
    private final ListarProdutoService listarProdutoService;
    private final DeletarProdutoService deletarProdutoService;
    private final ComprarProdutoService comprarProdutoService;
    private final VerificarEstoqueService verificarEstoqueService;
    private final ListarComprasService listarComprasService;
    private final AtualizarEstoqueService atualizarEstoqueService;
    private final GeraLoteService geraLoteService;

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
    public Integer cadastrarProduto(@RequestBody ProdutoRequest produtoRequest) {
        return cadastrarProdutoService.cadastrar(produtoRequest);
    }

    @PutMapping("comprar/{id}/{qtd}")
    public Boolean comprarProduto(@PathVariable("id") Integer id,
                                  @PathVariable("qtd") Integer qtd) {
        return comprarProdutoService.comprar(id, qtd);
    }

    @GetMapping("verificar/{id}/{qtd}")
    public Boolean verificar(@PathVariable Integer id, @PathVariable Integer qtd) {
        return verificarEstoqueService.verificar(id, qtd);
    }

    @GetMapping("listarCompras")
    public List<Compra> listarCompras() {
        return listarComprasService.listarCompras();
    }

    @PutMapping("atualizar/{id}/{qtd}")
    public Integer atualizar(@PathVariable Integer id, @PathVariable Integer qtd) {
        return atualizarEstoqueService.atualizar(id, qtd);
    }

    @PostMapping("loteCompras")
    public void gerarLoteCompras() {
        geraLoteService.geraLoteCompras();
    }
}

