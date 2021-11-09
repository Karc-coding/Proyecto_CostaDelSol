package com.store.app.service;

import com.store.app.entity.Huesped;
import com.store.app.repository.HuespedRepository;

public class HuespedServiceImpl implements HuespedService {
	
private HuespedRepository repository;
	
	public Huesped RegistrarHuesped(Huesped obj) {		
		return repository.save(obj);
	}

	public void EliminarHuesped(String id) {		
		repository.deleteById(id);
	}


}

