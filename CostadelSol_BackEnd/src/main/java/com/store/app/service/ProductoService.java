package com.store.app.service;

import java.util.List;

import com.store.app.entity.Producto;

public interface ProductoService {

	public List<Producto> listAll();
	
	public Producto createProducto(Producto producto);
	public List<Producto> findAllByDescriptionOrCategoria(String description, String categoria);
}
