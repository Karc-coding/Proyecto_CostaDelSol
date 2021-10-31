package com.store.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.entity.Factura;
import com.store.app.service.FacturaService;
import com.store.app.util.Constantes;

@RestController
@RequestMapping("rest/factura")
public class FacturaController {

	@Autowired
	private FacturaService facturaService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaFactura(@RequestBody Factura factura){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
			
			Factura objFac = facturaService.insertaFactura(factura);
			
			if(objFac == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
}
