package com.yee.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProdutoTest {

	private Produto Produto;
	
	@BeforeEach
	void setUp () {
		//Arrange
		Produto = new Produto(1L,"Toalha seca","Molhada",15);
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		Produto.setId(2L);
		//Assert
		assertEquals(2L, Produto.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		//Act
		Produto.setNome("Toalha");
		//Assert
		assertEquals("Toalha", Produto.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo descricao")
	void testDescricao() {
		//Act
		Produto.setDescricao("Toalha seca");
		//Assert
		assertEquals("Toalha seca", Produto.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo preco")
	void testPreco() {
		//Act
		Produto.setPreco(13);
		//Assert
		assertEquals(13, Produto.getPreco());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstrutorAll() {
		//Act
		Produto novoProduto = new Produto(3L,"Snickers","Crocante",11);
		//Assertion
		assertAll("novoProduto",
				()-> assertEquals (3L, novoProduto.getId()),
				()-> assertEquals ("Snickers", novoProduto.getNome()),
				()-> assertEquals ("Crocante", novoProduto.getDescricao()),
				()-> assertEquals (11, novoProduto.getPreco()));
	}

}
