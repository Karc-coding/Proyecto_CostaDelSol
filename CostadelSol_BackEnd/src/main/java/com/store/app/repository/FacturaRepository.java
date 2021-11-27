package com.store.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.app.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, String> {

	/*@Query("select f.Num_Fac from factura f order by 1 desc")
	public abstract List<String> listaIdFactura();*/
	
}
