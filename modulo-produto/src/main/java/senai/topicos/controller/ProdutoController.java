package senai.topicos.controller;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Delete;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import senai.topicos.entidades.Produto;

@RestController(value="API para manipulacao de estoque")
@RequestMapping("produtos")
@Api(description="Api de produtos")
public class ProdutoController {

	Map<Integer, Produto> mapaDeUsuario = new HashMap<Integer, Produto>();
	Integer contador = 1;

	 
	 @RequestMapping(value = "/cadastarProduto/", method = RequestMethod.POST)
	 public ResponseEntity<Integer> cadastrarProduto(
			 @RequestParam("nome") String nome,
			 @RequestParam("preco") Double preco)
					 
	 throws Exception{
		 System.out.println("Cadastrando produto");
		 
		 Produto prod = new Produto();
		 prod.id = contador;
		 prod.nome = nome;
		 prod.preco = preco;
		 prod.data = new Date();
		 
		 
		 mapaDeUsuario.put(prod.id,  prod);
		 contador++;
		 
		 
		 return ResponseEntity.ok(prod.id);
	 }
	 
	 @RequestMapping(value = "/buscarPorId/{id}", method = RequestMethod.GET)
	 public ResponseEntity<Produto> buscarPorId(
			 @PathVariable("id") Integer id)
	 
	 			throws Exception{
		 System.out.println("Buscando por ID");
		 
		 
		 if( null == mapaDeUsuario.get(id) ){
			 return new ResponseEntity(HttpStatus.NO_CONTENT);
	       }else {
	       return ResponseEntity.ok(mapaDeUsuario.get(id));
	       }
	 }
	 
	 @DeleteMapping(value = "/deletarPorId/{id}")
	 public ResponseEntity<Void>  deletarPorId(
			 @PathVariable("id") Integer id)
	 
	 			throws Exception{
		 
		 System.out.println("Deletando por ID");
		 
		 if( null == mapaDeUsuario.get(id)){
			 return new ResponseEntity(HttpStatus.NO_CONTENT);
	       }else {
	    	   mapaDeUsuario.remove(id);
	    	   return new ResponseEntity(HttpStatus.OK);
	       }
		
	 }
	 
	 @RequestMapping(value = "/listarProduto", method = RequestMethod.GET)
	 public ResponseEntity<List<Produto>> listarProduto() throws Exception{
		 System.out.println("listando produtos");
		return ResponseEntity.ok(new ArrayList<>(mapaDeUsuario.values()));
	 }
	 
		 	
	

}
