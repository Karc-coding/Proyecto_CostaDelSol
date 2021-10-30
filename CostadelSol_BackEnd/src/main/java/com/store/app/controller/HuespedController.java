package com.store.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.store.app.entity.Huesped;
import com.store.app.service.HuespedService;
import com.store.app.util.Constantes;

public class HuespedController {
	
/*	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> RegistrarHuesped(@RequestBody Huesped obj){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
									
			Huesped objHuesped = HuespedService.RegistrarHuesped(obj);
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
*/

}
