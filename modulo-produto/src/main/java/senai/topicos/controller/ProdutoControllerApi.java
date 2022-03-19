package senai.topicos.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Descreve a API") //TODO Editar
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
    ResponseEntity<Integer> cadastrarProduto(
        @ApiParam(value = "descreve o parametro", required = true)
        @RequestParam("nome") String nome, @RequestParam("preco") BigDecimal preco)
        throws Exception;


}
