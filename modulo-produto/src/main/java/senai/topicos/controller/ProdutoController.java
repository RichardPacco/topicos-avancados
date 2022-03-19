package senai.topicos.controller;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import senai.topicos.domain.entity.Produto;
import senai.topicos.dto.request.ProdutoDTO;
import senai.topicos.dto.response.ProdutoResponse;
import senai.topicos.service.produto.CadastrarProdutoService;
import senai.topicos.service.produto.ListarProdutoService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/produtos") //TODO v1 explicar
public class ProdutoController implements ProdutoControllerApi {

    private final CadastrarProdutoService cadastrarProdutoService;
    private final ListarProdutoService listarProdutoService;

    //@RequestMapping(value = "/cadastarProduto/", method = RequestMethod.POST)
    @PostMapping("/cadastrar/produto")
    public ResponseEntity<Integer> cadastrarProduto(
        @RequestParam("nome") String nome,
        @RequestParam("preco") BigDecimal preco) {

        System.out.println("Cadastrando produto");

        Produto prod = new Produto();
        prod.id = contador;
        prod.nome = nome;
        prod.preco = preco;
        prod.data = new Date();

        mapaDeUsuario.put(prod.id, prod);
        contador++;

        return ResponseEntity.ok(prod.id);
    }

    //	 @RequestMapping(value = "/buscarPorId/{id}", method = RequestMethod.GET)
    @GetMapping("/buscar/produto/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable("id") Integer id)

        throws Exception {
        System.out.println("Buscando por ID");

        if (null == mapaDeUsuario.get(id)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(mapaDeUsuario.get(id));
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable("id") Integer id) {

        System.out.println("Deletando por ID");

        if (null == mapaDeUsuario.get(id)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            mapaDeUsuario.remove(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @GetMapping("/listrar/produto")
    public List<ProdutoResponse> listarProduto() {
        return listarProdutoService.listar();
    }

    @PostMapping("/cadastrar/produto")
    public Integer cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return cadastrarProdutoService.cadastrar(produtoDTO);
    }
}
