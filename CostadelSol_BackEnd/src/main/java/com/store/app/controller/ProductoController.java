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

import com.store.app.entity.Producto;
import com.store.app.service.ProductoService;
import com.store.app.util.Constantes;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> createProducto(@RequestBody Producto pro) {

		Map<String, Object> salida = new HashMap<>();
		
		try {
			Producto objPro = productoService.createProducto(pro);
			if (objPro == null) {
				salida.put("message", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("data", objPro);
				salida.put("message", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("message", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
