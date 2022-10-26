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


import com.springboot.ejercicio1.entity.Venta;
import com.springboot.ejercicio1.service.VentaService;

@RestController
@RequestMapping("ventas")
public class VentaController {

	@Autowired
	private VentaService ventaService;

	@GetMapping
	public List<Venta> findAll() {
		return ventaService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Venta> findById(@PathVariable Long id) {
		return ResponseEntity.ok(ventaService.findById(id));
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Venta create(@RequestBody Venta venta) {
		return ventaService.createVentaFromProductos(venta);
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Venta update(@RequestBody Venta venta) {
		return ventaService.save(venta);
	}

	@DeleteMapping("/{id}")
	public Venta delete(@PathVariable Long id) throws IOException {
		Venta venta = ventaService.findById(id);
		ventaService.delete(id);
		return venta;
	}

}
