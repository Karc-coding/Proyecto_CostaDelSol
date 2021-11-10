package com.store.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.entity.Producto;
import com.store.app.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	@Autowired
	private ProductoRepository repository;
	
	@Override
	public Producto insertaProducto(Producto producto) {		
		return repository.save(producto);
	}
}
