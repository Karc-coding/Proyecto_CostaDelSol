package com.store.app.service;

import com.store.app.entity.Reserva;

public interface ReservaService {

	public abstract Reserva insertaSalida(Reserva obj);
	public abstract void eliminarSalida(String id);
	
}
