package com.store.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.entity.Producto;
import com.store.app.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	public ProductoRepository repo;

	@Override
	public List<Producto> listAll() {
		return repo.findAll();
	}
	
	
	@Override
	public Producto createProducto(Producto producto) {
		return repo.save(producto);
	}


	@Override
	public List<Producto> findAllByDescriptionOrCategoria(String description, String categoria) {
		return repo.findProductoByDescriptionOrCategoria(description, categoria);
	}


}
