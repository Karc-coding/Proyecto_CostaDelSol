package com.store.app.service;

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

	/*@Override
	public List<String> listaIdFactura() {		
		return repository.listaIdFactura();
	}*/

}
