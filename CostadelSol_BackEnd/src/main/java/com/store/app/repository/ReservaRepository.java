package com.store.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.app.entity.Habitacion;

public interface ReservaRepository extends JpaRepository<Reserva, String> {
	@Query("select h from Reserva h where state = 'Disponible'")
	public abstract List<Reserva> findreservaByStateDisponible();
}
