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

import com.store.app.entity.Producto;
import com.store.app.service.ProductoService;
import com.store.app.util.Constantes;

@RestController
@RequestMapping("rest/producto")
/*@CrossOrigin(origins = "http://localhost:4200")*/
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@PostMapping/*("/agregarProducto")*/
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaProducto(@RequestBody Producto pro) {
		Map<String, Object> dispo = new HashMap<>();
		try {
			LocalDateTime ldt = LocalDateTime.now();
			Producto objpro = productoService.insertaProducto(pro);
			if (objpro == null) {
				dispo.put("message", Constantes.MENSAJE_REG_ERROR);
			} else {
				dispo.put("message", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			dispo.put("message", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(dispo);
	}
}
