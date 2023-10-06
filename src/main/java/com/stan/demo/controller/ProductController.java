package com.stan.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stan.demo.model.Product;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/products")
public class ProductController {

	private List<Product> products = new ArrayList<>();

	@PostConstruct
	private void init() {
		products.add(new Product(1, 1.00, "Water Bottle"));
		products.add(new Product(2, 3.00, "Energy Drink"));
		products.add(new Product(3, 2.00, "Protein bar"));
	}

	@GetMapping("/all")
	public List<Product> getAllProducts() {
		return products;
	}

	@PostMapping("/add")
	public Product addProduct(@RequestBody Product p) {
		products.add(p);
		return p;
	}

	@DeleteMapping("/delete/{id}")
	public Product deleteProduct(@PathVariable long id) {
		for (Product product : products) {
			if (product.getId() == id) {
				products.remove(product);
				return product;
			}
		}
		throw new IllegalArgumentException("Product not found!");
	}
}
