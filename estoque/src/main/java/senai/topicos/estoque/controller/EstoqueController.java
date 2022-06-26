package senai.topicos.estoque.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import senai.topicos.estoque.domain.entity.Compra;
import senai.topicos.estoque.dto.response.ProdutoResponse;
import senai.topicos.estoque.dto.request.ProdutoRequest;
import senai.topicos.estoque.service.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/estoque") //TODO v1 explicar
public class EstoqueController implements EstoqueApi {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job processJob;

    private final ComprarProdutoService comprarProdutoService;
    private final CadastrarProdutoService cadastrarProdutoService;
    private final ListarEstoqueService listarEstoqueService;
    private final DeletarEstoqueService deletarEstoqueService;
    private final VerificarEstoqueService verificarEstoqueService;
    private final ListarComprasService listarComprasService;
    private final AtualizarEstoqueService atualizarEstoqueService;

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

    @PutMapping("comprar/{id}/{qtd}")
    public Boolean comprar(@PathVariable Integer id, @PathVariable Integer qtd){ return comprarProdutoService.comprar(id, qtd);
    }

    @GetMapping("{id}")
    public ProdutoResponse listarEstoque(@PathVariable("id") Integer id) {
        return listarEstoqueService.listar(id);
    }

    @GetMapping("verificar/{id}/{qtd}")
    public Boolean verificar(@PathVariable Integer id, @PathVariable Integer qtd) {
        return verificarEstoqueService.verificar(id, qtd);
    }

    @GetMapping("listarCompras")
    public List<Compra> listarCompras() {
        return listarComprasService.listar();
    }

    @PutMapping("atualizar/{id}/{qtd}")
    public Integer atualizar(@PathVariable Integer id, @PathVariable Integer qtd) {
        return atualizarEstoqueService.atualizar(id, qtd);
    }

    @PostMapping("loteCompras")
    public void gerarLoteCompras() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(processJob, jobParameters);
    }
}
