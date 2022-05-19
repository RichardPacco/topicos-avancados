package senai.topicos.estoque.service;

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
import org.springframework.stereotype.Service;
import senai.topicos.estoque.domain.entity.Compra;
import senai.topicos.estoque.domain.entity.Produto;
import senai.topicos.estoque.repository.CompraRepository;
import senai.topicos.estoque.repository.EstoqueRepository;

import java.math.BigDecimal;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ComprarProdutoService {

    private final EstoqueRepository repository;
    private final CompraRepository compraRepository;

    public Boolean comprar(Integer id, Integer qtd){
        Produto prod = repository.findById(id);
        int quantidadeRestante = prod.getQuantidadeEstoque() - qtd;
        if (quantidadeRestante < 0) {
            return false;
        }
        prod.setQuantidadeEstoque(quantidadeRestante);
        repository.saveProduto(prod);

        registrarCompra(qtd, prod);

        return true;
    }

    private void registrarCompra(Integer qtd, Produto prod){
        Compra compra = new Compra();
        compra.setNomeProduto(prod.getNome());
        compra.setQuantidade(qtd);
        compra.setDataVenda(new Date());
        compra.setPrecoUnidade(prod.getPreco());

        BigDecimal valorTotal = prod.getPreco().multiply(BigDecimal.valueOf(qtd));
        compra.setValorTotal(valorTotal);

        compraRepository.add(compra);
        }
    }
