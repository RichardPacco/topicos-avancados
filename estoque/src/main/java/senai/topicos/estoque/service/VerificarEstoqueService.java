package senai.topicos.estoque.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.estoque.domain.entity.Produto;
import senai.topicos.estoque.repository.EstoqueRepository;

@Service
@RequiredArgsConstructor
public class VerificarEstoqueService {

    private final EstoqueRepository repository;

    public Boolean verificar(Integer id, Integer qtd) {
        Produto prod = repository.findById(id);
        int kubanakan = prod.getQuantidadeEstoque() - qtd;
        return kubanakan >= 0;

    }
}