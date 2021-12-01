package com.store.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.app.entity.Factura;
import com.store.app.repository.FacturaRepository;

@Service
public class FacturaServiceImp implements FacturaService {

	@Autowired
	private FacturaRepository repository;
	
	@Override
	public Factura insertaFactura(Factura factura) {		
		return repository.save(factura);
	}

	@Override
	public List<Factura> listarFactura() {		
		return repository.findAll();
	}


	/*@Override
	public List<String> listaIdFactura() {		
		return repository.listaIdFactura();
	}*/
	

	@Override
	public List<Factura> findAllByRucOrDniOrHabitacion(String ruc, String dni, String habitacion) {
		return repository.findFacturaByRucOrDniOrHabitacion(ruc, dni, habitacion);
	}
	
}
