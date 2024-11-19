package com.yee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yee.entities.Produto;
import com.yee.services.ProdutoService;

@RestController
@RequestMapping("/api/Produto")
public class ProdutoController {

	@Autowired
	private ProdutoService ProdutoService;
	
	@PostMapping
	public ResponseEntity<Produto> salvarProduto(@RequestBody Produto Produto) {
		Produto novoProduto = ProdutoService.salvarProduto(Produto);
		return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> listarTodos() {
		List<Produto> Produtos = ProdutoService.getAllProduto();
		return new ResponseEntity<>(Produtos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		Produto Produto = ProdutoService.getProdutoById(id);
		if (Produto != null) {
			return new ResponseEntity<>(Produto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id,
			@RequestBody Produto Produto) {
		
		Produto existingProduto = ProdutoService.getProdutoById(id);
		if (existingProduto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Produto.setId(id);
		Produto ProdutoAtualizado = ProdutoService.updateProduto(id, Produto);
		return new ResponseEntity<>(ProdutoAtualizado, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProduto (@PathVariable Long id) {
		Produto existingProduto = ProdutoService.getProdutoById(id);
		if (existingProduto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ProdutoService.deleteProduto(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
