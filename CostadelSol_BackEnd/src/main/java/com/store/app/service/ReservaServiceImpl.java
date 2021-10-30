package com.store.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.entity.Reserva;
import com.store.app.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository repository;
	
	@Override
	public Reserva insertaSalida(Reserva obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarSalida(String id) {
		// TODO Auto-generated method stub
		
	}

}
