package com.store.app.service;

import java.util.List;

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
		return repository.save(obj);
	}

	@Override
	public void eliminarSalida(String id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Reserva> listaReserva() {		
		return repository.findAll();
	}

}
