package senai.topicos.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import senai.topicos.domain.entity.Compra;
import senai.topicos.dto.request.ProdutoRequest;
import senai.topicos.dto.response.ProdutoResponse;

import java.util.List;

@Api(tags = "API Produtos") //TODO Editar
public interface ProdutoControllerApi {

    @ApiOperation(value = "Cadastra determinado produto.",
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
    Integer cadastrarProduto(
            @ApiParam(value = "descreve o parametro", required = true)
            @RequestBody ProdutoRequest produtoRequest);

    ProdutoResponse listarProduto(@PathVariable("id") Integer id);

    List<ProdutoResponse> listarTodos();

    void delete(Integer id);

    Boolean comprarProduto(@PathVariable("id") Integer id,
                           @PathVariable("qtd") Integer qtd);

    Boolean verificar(@PathVariable("id") Integer id,
                      @PathVariable("qtd") Integer qtd);

    List<Compra> listarCompras();


    Integer atualizar(@PathVariable Integer id,
                      @PathVariable Integer qtd);

    void gerarLoteCompras();
}
