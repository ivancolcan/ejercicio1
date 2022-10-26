package com.springboot.ejercicio1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.ejercicio1.dao.ClienteDao;
import com.springboot.ejercicio1.entity.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

}
