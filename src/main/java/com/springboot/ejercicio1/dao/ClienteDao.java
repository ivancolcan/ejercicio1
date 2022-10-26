package com.springboot.ejercicio1.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ejercicio1.entity.Cliente;

@Repository
public interface ClienteDao extends  CrudRepository<Cliente, Long> {
	
}
