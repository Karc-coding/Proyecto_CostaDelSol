package com.store.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.entity.Huesped;
import com.store.app.repository.HuespedRepository;

    @Service
public class HuespedServiceImpl implements HuespedService {
	@Autowired
private HuespedRepository repository;

	@Override
	public Huesped RegistrarHuesped(Huesped obj) {
		return repository.save(obj);
	}

	@Override
	public void EliminarHuesped(String id) {
		repository.deleteById(id);
		
	}

}

