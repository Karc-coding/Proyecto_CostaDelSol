package com.store.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.store.app.entity.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, String> {

	@Query("select h from Habitacion h where state = 'Disponible'")
	public abstract List<Habitacion> findHabitacionByStateDisponible();

	@Query("select h from Habitacion h where (h.state is '' or h.state like :p_state) and"
			+ "( :p_description is '' or h.description like :p_description )")
	public abstract List<Habitacion> findHabitacionByStateOrDescription(@Param("p_state") String state,
			@Param("p_description") String description);

}
