package com.springboot.ejercicio1.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.ejercicio1.entity.Producto;
import com.springboot.ejercicio1.service.ProductoService;

@RestController
@RequestMapping("productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping
	public List<Producto> findAll() {
		return productoService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Producto> findById(@PathVariable Long id) {
		return ResponseEntity.ok(productoService.findById(id));
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		return productoService.save(producto);
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Producto update(@RequestBody Producto producto) {
		return productoService.save(producto);
	}

	@DeleteMapping("/{id}")
	public Producto delete(@PathVariable Long id) throws IOException {
		Producto cliente = productoService.findById(id);
		productoService.delete(id);
		return cliente;
	}

}
