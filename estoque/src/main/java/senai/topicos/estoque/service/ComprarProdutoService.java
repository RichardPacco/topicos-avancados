package senai.topicos.estoque.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.estoque.dto.request.OrdemCompraRequest;
import senai.topicos.estoque.repository.EstoqueRepository;

@Service
@RequiredArgsConstructor
public class ComprarProdutoService {

    private final EstoqueRepository repository;

//    public Integer comprar(OrdemCompraRequest request) {
//    //TODO adicionar validator
//
//
//
//    }
}
