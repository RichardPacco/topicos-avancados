package senai.topicos.service.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.repository.ProdutoRepository;

@Service
@RequiredArgsConstructor
public class DeletarProdutoService {

    public final ProdutoRepository repository;

    public void delete(Integer id){
        repository.delete(id);
    }
}
