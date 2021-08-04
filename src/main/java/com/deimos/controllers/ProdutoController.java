package com.deimos.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.deimos.dto.CadastrarProdutoDto;
import com.deimos.entities.Produto;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {
	
	@GET
	public List<Produto> buscarTodosProdutos(){
		
		return Produto.listAll();
	}
	
	@POST
	@Transactional
	public void criarProduto(CadastrarProdutoDto dto){
		
		Produto produto = new Produto();
		
		produto.setNome(dto.getNome());
		produto.setValor(dto.getValor());
		
		produto.persist();
	}
	
	@PATCH
	@Path("{id}")
	@Transactional
	public void atualizarProduto(@PathParam("id")Long id ,BigDecimal valor) {
		
		Optional<Produto> produtoOp = Produto.findByIdOptional(id);
		
		if(produtoOp.isPresent()) {
			Produto produto = produtoOp.get();
			
			produto.setValor(valor);
			
			produto.persist();
		}else {
			throw new NotFoundException();
		}
	}
	
	@DELETE
	@Path("{id}")
	@Transactional
	public void apagarProduto(@PathParam("id")Long id) {
		Optional<Produto> produtoOP = Produto.findByIdOptional(id);
		
		produtoOP.ifPresentOrElse(Produto::delete, () -> {
			throw new NotFoundException();
		});
	}
}