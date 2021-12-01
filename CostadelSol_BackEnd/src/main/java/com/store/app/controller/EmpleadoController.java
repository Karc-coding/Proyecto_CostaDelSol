package com.store.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.entity.Empleado;
import com.store.app.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping("/listAll")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listAllEmpleado() {

		Map<String, Object> salida = new HashMap<>();

		try {
			List<Empleado> list = empleadoService.listAll();
			if (CollectionUtils.isEmpty(list)) {
				salida.put("message", "No existen empleados");
			} else {
				salida.put("list", list);
				salida.put("message", "Se hallo " + list.size() + " empleado(s)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}
	
}
