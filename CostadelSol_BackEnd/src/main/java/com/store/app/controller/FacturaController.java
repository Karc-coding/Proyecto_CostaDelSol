package com.store.app.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.entity.Factura;
import com.store.app.entity.Habitacion;
import com.store.app.service.FacturaService;
import com.store.app.util.Constantes;

@RestController
@RequestMapping("/rest/factura")
@CrossOrigin(origins = "http://localhost:4200")
public class FacturaController {

	@Autowired
	private FacturaService facturaService;
	
	/*@Autowired
	private ReservaService reservaService;*/
	
	@GetMapping("/listaFactura")
	@ResponseBody
	public ResponseEntity<List<Factura>> listaProveedor() {
		List<Factura> lista = facturaService.listarFactura();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/agregarFactura")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaFactura(@RequestBody Factura factura){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {				
			
			//INSERTAR FECHA ACTUAL
			LocalDateTime ldt = LocalDateTime.now();
			factura.setFec_Act(Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()));
			
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
	
	
	@GetMapping("/listFacturaForRucOrDniOrHabitacion")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listFacturaRucOrDniOrHabitacionId(
			@RequestParam(name = "ruc", defaultValue = "", required = false) String ruc,
			@RequestParam(name = "dni", defaultValue = "", required = false) String dni,
			@RequestParam(name = "habitacion", defaultValue = "", required = false) String habitacion) {
		
		Map<String, Object> salida = new HashMap<>();
		
		try {
			List<Factura> list = facturaService.findAllByRucOrDniOrHabitacion("%" + ruc + "%", "%" + dni + "%", "%" + habitacion + "%");
			if (CollectionUtils.isEmpty(list)) {
				salida.put("message", "No existen habitaciones en la consulta");
			} else {
				salida.put("list", list);
				salida.put("message", "Se hallo " + list.size() + " habitacion(es)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}
	
}
