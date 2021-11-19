package com.store.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.app.entity.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, String> {

	@Query("select h from Habitacion h where state = 'Disponible'")
	public abstract List<Habitacion> findHabitacionByStateDisponible();
	
}
