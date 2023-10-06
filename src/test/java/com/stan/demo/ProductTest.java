package com.stan.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.stan.demo.model.Product;

class ProductTest {

	@Test
	void testProduct() {
		Product product = new Product();
		product.setId(1L);
		product.setName("test");
		product.setPrice(4.99);

		Assertions.assertEquals("test", product.getName());
		Assertions.assertEquals(1L, product.getId());
		Assertions.assertEquals(4.99, product.getPrice());

	}
}
