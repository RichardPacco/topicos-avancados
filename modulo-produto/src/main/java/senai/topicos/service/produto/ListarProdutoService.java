package senai.topicos.service.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.topicos.dto.response.ProdutoResponse;
import senai.topicos.feign.FeignEstoqueApi;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarProdutoService {

    private final FeignEstoqueApi feign;

    public ProdutoResponse listar(Integer id) {
        return feign.listarEstoque(id);
    }

    public List<ProdutoResponse> listarTodos() {
        return feign.listarTodos();
    }
}
