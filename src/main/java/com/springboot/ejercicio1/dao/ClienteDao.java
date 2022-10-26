package com.springboot.ejercicio1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ejercicio1.entity.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long> {

}
