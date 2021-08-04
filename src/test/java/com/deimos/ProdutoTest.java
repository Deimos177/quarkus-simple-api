package com.deimos;

import org.junit.Assert;
import org.junit.Test;

import com.deimos.entities.Produto;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@QuarkusTestResource(DataBaseLifeCycle.class)
public class ProdutoTest {
	
	@Test
	public void testProduto() {
		Assert.assertEquals(1, Produto.count());
	}
}