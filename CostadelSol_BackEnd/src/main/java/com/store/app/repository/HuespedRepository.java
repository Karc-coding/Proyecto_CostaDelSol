package com.store.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.store.app.entity.Huesped;

@EnableJpaRepositories

public interface HuespedRepository extends JpaRepository<Huesped, String> {

	@Query("select h from Huesped h where ((h.nombre is '' or h.nombre like :p_name) or (h.apellido is '' or h.apellido like :p_lastn)) and"
			+ "(h.dni is '' or h.dni like :p_dni) and"
			+ "(h.telefono is '' or h.telefono like :p_telefono )")
	public abstract List<Huesped> findHuespedByNameOrDniOrTelefono(@Param("p_name") String name,
			@Param("p_lastn") String lastName, @Param("p_dni") String dni, @Param("p_telefono") String telefono);

}
