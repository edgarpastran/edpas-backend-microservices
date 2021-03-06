package com.edpas.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edpas.exception.ModelNotFoundException;
import com.edpas.model.Product;
import com.edpas.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> list() {
		List<Product> list = this.productService.getAll();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Product>> listPageable(Pageable pageable) {
		Page<Product> list = this.productService.listPageable(pageable);
		return new ResponseEntity<Page<Product>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> find(@PathVariable("id") Integer id) {
		Product object = this.productService.getOne(id);
		if (object.getIdProduct() <= 0) {
			throw new ModelNotFoundException("Id not found: "+id);
		}
		return new ResponseEntity<Product>(object, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> register(@Valid @RequestBody Product product) {
		Product saved = this.productService.insert(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getIdProduct()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@Valid @RequestBody Product product) {
		this.productService.update(product);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		Product object = this.productService.getOne(id);
		if (object.getIdProduct() <= 0) {
			throw new ModelNotFoundException("Id not found: "+id);
		}
		else {
			this.productService.delete(id);
		}
		return new ResponseEntity<Object>(object, HttpStatus.OK);
	}
}
