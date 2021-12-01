package com.store.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.entity.Habitacion;
import com.store.app.service.HabitacionService;
import com.store.app.util.Constantes;

@RestController
@RequestMapping("/habitacion")
@CrossOrigin(origins = "http://localhost:4200")
public class HabitacionController {

	@Autowired
	private HabitacionService habitacionService;

	@GetMapping("/listAll")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listAllHabitacion() {

		Map<String, Object> salida = new HashMap<>();

		try {
			List<Habitacion> list = habitacionService.listAll();
			if (CollectionUtils.isEmpty(list)) {
				salida.put("message", "No existen habitaciones");
			} else {
				salida.put("list", list);
				salida.put("message", "Se hallo " + list.size() + " habitacion(es)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}

	@GetMapping("/listDisponible")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listHabitacionDisponibles() {

		Map<String, Object> salida = new HashMap<>();

		try {
			List<Habitacion> list = habitacionService.findAllByStateDisponible();
			if (CollectionUtils.isEmpty(list)) {
				salida.put("message", "No existen habitaciones disponibles");
			} else {
				salida.put("list", list);
				salida.put("message", "Se hallo " + list.size() + " habitacion(es) disponible(s)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}

	@GetMapping("/listHabitacionForDescriptionOrState")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listHabitacionDescriptionOrState(
			@RequestParam(name = "description", defaultValue = "", required = false) String description,
			@RequestParam(name = "state", defaultValue = "", required = false) String state) {
		
		Map<String, Object> salida = new HashMap<>();
		
		try {
			List<Habitacion> list = habitacionService.findAllByStateOrDescription("%" + state + "%", "%" + description + "%");
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

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getHabitacion(@PathVariable("id") String id) {

		Map<String, Object> salida = new HashMap<>();

		try {
			Habitacion hab = habitacionService.getHabitacion(id);
			if (hab == null) {
				salida.put("message", "No existe la habitacion con el id " + id);
			} else {
				salida.put("data", hab);
				salida.put("message", "Habitacion encontrado");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}

	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> createHabitacion(@RequestBody Habitacion hab) {

		Map<String, Object> salida = new HashMap<>();

		try {
			Habitacion objHab = habitacionService.createHabitacion(hab);
			if (objHab == null) {
				salida.put("message", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("data", objHab);
				salida.put("message", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("message", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/update")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> updateHabitacion(@RequestBody Habitacion hab) {

		Map<String, Object> salida = new HashMap<>();

		try {
			Habitacion objHab = habitacionService.updateHabitacion(hab);
			if (objHab == null) {
				salida.put("message", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("data", objHab);
				salida.put("message", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("message", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteHabitacion(@PathVariable("id") String id) {

		Map<String, Object> salida = new HashMap<>();

		try {
			Habitacion objHab = habitacionService.deleteHabitacion(id);
			if (objHab == null) {
				salida.put("message", Constantes.MENSAJE_ELI_NO_EXISTE_ID);
			} else {
				salida.put("data", objHab);
				salida.put("message", Constantes.MENSAJE_ELI_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("message", Constantes.MENSAJE_ELI_ERROR_ADM);
		}
		return ResponseEntity.ok(salida);

	}

}
