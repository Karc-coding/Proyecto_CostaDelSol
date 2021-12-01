package com.store.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.entity.Empleado;
import com.store.app.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	public EmpleadoRepository repo;

	@Override
	public List<Empleado> listAll() {
		return repo.findAll();
	}
	
}
