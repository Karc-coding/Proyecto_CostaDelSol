package com.store.app.service;

import java.util.List;

import com.store.app.entity.Habitacion;

public interface HabitacionService {
	
	public List<Habitacion> listAll();
	public Habitacion createHabitacion(Habitacion habitacion);
	public Habitacion updateHabitacion(Habitacion habitacion);
	public Habitacion deleteHabitacion(String id);
	public Habitacion getHabitacion(String id);
	
	public List<Habitacion> findAllByStateDisponible();
	public List<Habitacion> findAllByStateOrDescription(String state, String description);

}
