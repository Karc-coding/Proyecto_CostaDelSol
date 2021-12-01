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

import com.store.app.entity.Huesped;
import com.store.app.service.HuespedService;
import com.store.app.util.Constantes;

@RestController
@RequestMapping("/registrarHuesped")
@CrossOrigin(origins = "http://localhost:4200")
public class HuespedController {

	@Autowired
	private HuespedService huespedService;

	@GetMapping("/listAll")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listAllHuesped() {

		Map<String, Object> salida = new HashMap<>();

		try {
			List<Huesped> list = huespedService.listAll();
			if (CollectionUtils.isEmpty(list)) {
				salida.put("message", "No existen huespedes");
			} else {
				salida.put("list", list);
				salida.put("message", "Se hallo " + list.size() + " huesped(es)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}

	@GetMapping("/listHuespedForNameOrDniOrTelefono")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listHuespedNameOrDniOrTelefono(
			@RequestParam(name = "name", defaultValue = "", required = false) String name,
			@RequestParam(name = "lastName", defaultValue = "", required = false) String lastName,
			@RequestParam(name = "dni", defaultValue = "", required = false) String dni,
			@RequestParam(name = "telefono", defaultValue = "", required = false) String telefono) {

		Map<String, Object> salida = new HashMap<>();

		try {
			List<Huesped> list = huespedService.findAllByNameOrDniOrTelefono("%" + name + "%", "%" + lastName + "%",
					"%" + dni + "%", "%" + telefono + "%");
			if (CollectionUtils.isEmpty(list)) {
				salida.put("message", "No existen huespedes en la consulta");
			} else {
				salida.put("list", list);
				salida.put("message", "Se hallo " + list.size() + " huesped(es)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}

	@PostMapping("/registrar")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> RegistrarHuesped(@RequestBody Huesped obj) {

		Map<String, Object> salida = new HashMap<String, Object>();

		try {
			obj.setEstado("Activo");
			Huesped objHuesped = huespedService.RegistrarHuesped(obj);
			if (objHuesped == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
