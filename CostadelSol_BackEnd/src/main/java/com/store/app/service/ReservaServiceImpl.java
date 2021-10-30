package com.store.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.entity.Reserva;
import com.store.app.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService{
	@Autowired
	public ReservaRepository repo;
	
	@Override
	public List<Reserva> findAll() {
		return repo.findAll();
	}

	@Override
	public Reserva createReserva(Reserva reserva) {
		return repo.save(reserva);
	}

	@Override
	public Reserva updateReserva(Reserva reserva) {
		return repo.save(reserva);
	}

	@Override
	public Reserva deleteReserva(String dni) {
		reserva res = getReserva(dni);
		if (res == null) {
			return null;
		}
		repo.deleteById(id);
		return res;
	}

	@Override
	public Reserva getReserva(String dni) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Reserva> findAllByStateDisponible() {
		return repo.findReservaByStateDisponible();
	}
}
