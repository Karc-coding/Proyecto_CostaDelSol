package com.store.app.service;

import java.util.List;

import com.store.app.entity.Reserva;

public interface ReservaService {

	public abstract List<Reserva> listaReserva();
	public abstract Reserva insertaSalida(Reserva obj);
	public abstract void eliminarSalida(String id);
	
}
