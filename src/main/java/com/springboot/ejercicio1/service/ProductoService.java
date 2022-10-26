package com.springboot.ejercicio1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.ejercicio1.dao.ProductoDao;
import com.springboot.ejercicio1.entity.Producto;

@Service
public class ProductoService {

	@Autowired
	private ProductoDao productoDao;

	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}

	public void delete(Long id) {
		productoDao.deleteById(id);
	}

}
