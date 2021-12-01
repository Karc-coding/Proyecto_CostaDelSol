package com.store.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.store.app.entity.Factura;
import com.store.app.entity.Habitacion;

public interface FacturaRepository extends JpaRepository<Factura, String> {

	/*@Query("select f.Num_Fac from factura f order by 1 desc")
	public abstract List<String> listaIdFactura();*/
	
	@Query("select f from Factura f inner join f.dni hus inner join f.habitacionId hab where"
			+ "(f.ruc is '' or f.ruc like :p_ruc) and"
			+ "( hus.dni is '' or hus.dni like :p_dni ) and"
			+ "( hab.description is '' or hab.description like :p_habitacion )")
	public abstract List<Factura> findFacturaByRucOrDniOrHabitacion(@Param("p_ruc") String ruc,
			@Param("p_dni") String dni, @Param("p_habitacion") String habitacion);
	
}
