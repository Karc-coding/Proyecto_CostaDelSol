package com.store.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.entity.Habitacion;
import com.store.app.repository.HabitacionRepository;

@Service
public class HabitacionServiceImpl implements HabitacionService {

	@Autowired
	public HabitacionRepository repo;
	
	@Override
	public List<Habitacion> listAll() {
		return repo.findAll();
	}

	@Override
	public Habitacion createHabitacion(Habitacion habitacion) {
		return repo.save(habitacion);
	}

	@Override
	public Habitacion updateHabitacion(Habitacion habitacion) {
		return repo.save(habitacion);
	}

	@Override
	public Habitacion deleteHabitacion(String id) {
		Habitacion hab = getHabitacion(id);
		if (hab == null) {
			return null;
		}
		repo.deleteById(id);
		return hab;
	}

	@Override
	public Habitacion getHabitacion(String id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Habitacion> findAllByStateDisponible() {
		return repo.findHabitacionByStateDisponible();
	}

	@Override
	public List<Habitacion> findAllByStateOrDescription(String state, String description) {
		return repo.findHabitacionByStateOrDescription(state, description);
	}

}
