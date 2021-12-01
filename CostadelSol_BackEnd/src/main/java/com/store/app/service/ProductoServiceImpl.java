package com.store.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.store.app.entity.Producto;
import com.store.app.repository.ProductoRepository;

public class ProductoServiceImpl implements ProductoService{

	@Autowired
	public ProductoRepository repo;
	
	@Override
	public Producto createProducto(Producto producto) {
		return repo.save(producto);
	}

}
