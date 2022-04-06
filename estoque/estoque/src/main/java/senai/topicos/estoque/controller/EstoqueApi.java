package senai.topicos.estoque.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import senai.topicos.estoque.dto.request.OrdemCompraRequest;
import senai.topicos.estoque.dto.request.ProdutoRequest;

@Api(tags = "API Estoque") //TODO Editar
public interface EstoqueApi {


    @ApiOperation(value = "Cadastra determinada compra.",
            notes = "Nesta etapa o cadastro de dados do produto é feito utilizando a b ou c, "
                    + "se o produto for cadastrado com sucesso, ira retonar um id."
    )
    @ApiResponses({
            @ApiResponse(code = 201, message = "Operação realizada com sucesso."),
            @ApiResponse(code = 400, message = "Parâmetros inválidos."),
            @ApiResponse(code = 404, message = "Nenhum resultado encontrado."),
            @ApiResponse(code = 500, message = "Falha inesperada."),
            @ApiResponse(code = 501, message = "Serviço indisponível.")
    })

    Integer cadastrarProduto(@RequestBody ProdutoRequest request);

//    Integer comprarProduto(@RequestBody OrdemCompraRequest request);
}
