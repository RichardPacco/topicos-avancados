package senai.topicos.entidades;

import java.util.Date;

public class Produto {

	public Integer id;
	public Date data; 
	public String nome;
	public Double preco;
	
	
	@Override
	public String toString() {
		return "Produto [id = " + id + ", data = " + data + ", nome = " + nome + ", preco = " + preco + "]";
	}
	
	
}
