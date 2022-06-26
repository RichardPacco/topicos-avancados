package senai.topicos.estoque.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.estoque.domain.entity.Produto;
import senai.topicos.estoque.repository.EstoqueRepository;

@Service
@RequiredArgsConstructor
public class AtualizarEstoqueService {

    private final EstoqueRepository repository;

    public Integer atualizar(Integer id, Integer qtd) {

        Produto prod = repository.findById(id);
        Integer acrescentado = prod.getQuantidadeEstoque() + qtd;
        prod.setQuantidadeEstoque(acrescentado);
        repository.save(prod);

        return prod.getQuantidadeEstoque();
    }
}
