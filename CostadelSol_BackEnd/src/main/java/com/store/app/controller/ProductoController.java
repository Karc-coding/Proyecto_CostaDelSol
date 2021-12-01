package com.store.app.controller;

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

import com.store.app.entity.Habitacion;
import com.store.app.entity.Producto;
import com.store.app.service.ProductoService;
import com.store.app.util.Constantes;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping("/listAll")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listAllProducto() {

		Map<String, Object> salida = new HashMap<>();

		try {
			List<Producto> list = productoService.listAll();
			if (CollectionUtils.isEmpty(list)) {
				salida.put("message", "No existen productos");
			} else {
				salida.put("list", list);
				salida.put("message", "Se hallo " + list.size() + " producto(s)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/listProductoForDescriptionOrCategoria")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listProductoDescriptionOrCategoria(
			@RequestParam(name = "description", defaultValue = "", required = false) String description,
			@RequestParam(name = "categoria", defaultValue = "", required = false) String categoria) {
		
		Map<String, Object> salida = new HashMap<>();
		
		try {
			List<Producto> list = productoService.findAllByDescriptionOrCategoria("%" + description + "%", "%" + categoria + "%");
			if (CollectionUtils.isEmpty(list)) {
				salida.put("message", "No existen productos en la consulta");
			} else {
				salida.put("list", list);
				salida.put("message", "Se hallo " + list.size() + " producto(s)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}

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
