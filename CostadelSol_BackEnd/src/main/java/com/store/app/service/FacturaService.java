package com.store.app.service;

import java.util.List;

import com.store.app.entity.Factura;

public interface FacturaService {

	public abstract Factura insertaFactura(Factura factura);
	public abstract List<Factura> listarFactura();
	//public abstract List<String> listaIdFactura();
	
	public abstract List<Factura> findAllByRucOrDniOrHabitacion(String ruc, String dni, String habitacion);
}
