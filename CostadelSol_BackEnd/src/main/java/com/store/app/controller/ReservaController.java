package com.store.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.entity.Reserva;
import com.store.app.service.ReservaService;
import com.store.app.util.Constantes;

@RestController
@RequestMapping("rest/reserva")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Reserva>> listaReserva(){
		List<Reserva> lista = reservaService.listaReserva();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaProveedor(@RequestBody Reserva reserva){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
					
			Reserva objReserva = reservaService.insertaSalida(reserva);
			if(objReserva== null){
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
