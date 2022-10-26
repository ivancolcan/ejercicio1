package com.springboot.ejercicio1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.ejercicio1.dao.ClienteDao;
import com.springboot.ejercicio1.dao.ProductoDao;
import com.springboot.ejercicio1.dao.VentaDao;
import com.springboot.ejercicio1.entity.Cliente;
import com.springboot.ejercicio1.entity.Producto;
import com.springboot.ejercicio1.entity.Venta;

@Service
public class VentaService {

	@Autowired
	private VentaDao ventaDao;

	@Autowired
	private ProductoDao productoDao;

	@Autowired
	private ClienteDao clienteDao;

	@Transactional(readOnly = true)
	public List<Venta> findAll() { 
		return (List<Venta>) ventaDao.findAll();
	}

	@Transactional(readOnly = true)
	public Venta findById(Long id) {
		return ventaDao.findById(id).orElse(null);
	}

	public Venta save(Venta venta) {
		return ventaDao.save(venta);
	}

	public void delete(Long id) {
		ventaDao.deleteById(id);
	}
	
	public Venta createVentaFromProductos(Venta venta) {
		Venta newVenta = new Venta();
		
		try {
			Producto producto = productoDao.findById(venta.getProducto().getClave()).orElse(null);
			Cliente cliente = clienteDao.findById(venta.getCliente().getNoCliente()).orElse(null);
			Double subtotal = producto.getPrecioUnit() * venta.getCantidad();
			Double total = subtotal * (1 + venta.getIva()/100); 
			newVenta.setSubtotal(subtotal);
			newVenta.setIva(venta.getIva());
			newVenta.setCantidad(venta.getCantidad());
			newVenta.setCliente(cliente);
			newVenta.setProducto(producto);
			newVenta.setTotal(total);	
		} catch (Exception e) {
			System.out.println("Error al calcular el importe de la venta: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		return ventaDao.save(newVenta);
	}


}
