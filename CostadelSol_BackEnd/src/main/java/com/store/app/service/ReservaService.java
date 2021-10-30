package com.store.app.service;
import java.util.List;

import com.store.app.entity.Reserva;
public interface ReservaService {
	
	public List<reserva> findAll();
	public Reserva createReserva(Reserva reserva);
	public Reserva updateReserva(Reserva reserva);
	public Reserva deleteReserva(String id);
	public Reserva getReserva(String id);
	
	public List<Reserva> findAllByStateDisponible();

}
