package com.springboot.ejercicio1.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ejercicio1.entity.Producto;

@Repository
public interface ProductoDao extends CrudRepository<Producto, Long> {

}
