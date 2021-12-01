package com.store.app.service;

import java.util.List;

import com.store.app.entity.Huesped;

public interface HuespedService {
	
	public abstract List<Huesped> listAll();
	public List<Huesped> findAllByNameOrDniOrTelefono(String name, String lastName, String dni, String telefono);
	
	public abstract  Huesped RegistrarHuesped(Huesped obj);
	public abstract void EliminarHuesped(String id);

}

