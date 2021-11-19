package com.store.app.service;

import com.store.app.entity.Huesped;

public interface HuespedService {
	
	public abstract  Huesped RegistrarHuesped(Huesped obj);
	public abstract void EliminarHuesped(String id);

}

