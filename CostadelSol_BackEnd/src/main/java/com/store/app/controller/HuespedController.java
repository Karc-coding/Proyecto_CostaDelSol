package com.store.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.entity.Huesped;
import com.store.app.service.HuespedService;
import com.store.app.util.Constantes;

@RestController
@RequestMapping("/RegistrarHuesped")
@CrossOrigin(origins = "http://localhost:4200")
public class HuespedController {
	@Autowired
	private HuespedService huespedService;

	@PostMapping("/registrar")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> RegistrarHuesped(@RequestBody Huesped obj){
		
		Map<String, Object> salida = new HashMap<String, Object>();
	
		
		try {
									
			Huesped objHuesped = huespedService.RegistrarHuesped(obj);
			if(objHuesped == null){
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

