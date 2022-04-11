package senai.topicos.estoque.service;

import lombok.RequiredArgsConstructor;
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

    public Boolean comprar(Integer id, Integer qtd) {

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

    private void registrarCompra(Integer qtd, Produto prod) {
        Compra compra = new Compra();
        compra.setNomeProduto(prod.getNome());
        compra.setQuantidade(qtd);
        compra.setDataVenda(new Date());

        BigDecimal valorTotal = prod.getPreco().multiply(BigDecimal.valueOf(qtd));
        compra.setValorTotal(valorTotal);

        compraRepository.add(compra);
    }
}
