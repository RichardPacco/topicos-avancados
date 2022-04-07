package senai.topicos.service.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.dto.response.ProdutoResponse;
import senai.topicos.feign.EstoqueApi;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarProdutoService {

    private final EstoqueApi feign;

    public ProdutoResponse listar(Integer id) {
        return feign.listarEstoque(id);
    }

    public List<ProdutoResponse> listarTodos() {
        return feign.listarTodos();
    }
}
