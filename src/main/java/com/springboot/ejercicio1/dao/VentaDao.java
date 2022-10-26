package com.springboot.ejercicio1.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ejercicio1.entity.Venta;

@Repository
public interface VentaDao extends CrudRepository<Venta, Long> {

}
