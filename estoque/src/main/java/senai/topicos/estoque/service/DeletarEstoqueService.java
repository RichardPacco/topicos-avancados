package senai.topicos.estoque.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.estoque.repository.EstoqueRepository;

@Service
@RequiredArgsConstructor
public class DeletarEstoqueService {

    private final EstoqueRepository repository;

    public void delete(Integer id){
        repository.delete(id);
    }
}
