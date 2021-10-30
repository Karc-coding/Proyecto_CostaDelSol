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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.app.entity.Reserva;
import com.store.app.service.ReservaService;
import com.store.app.util.Constantes;

@RestController
@RequestMapping("/reserva")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaController {
	@Autowired
	private Reservaservice reservaservice;

	@GetMapping("/listAll")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listAllReserva() {

		Map<String, Object> salida = new HashMap<>();

		try {
			List<Habitacion> list = reservaService.findAll();
			if (CollectionUtils.isEmpty(list)) {
				salida.put("message", "No existen reserva");
			} else {
				salida.put("list", list);
				salida.put("message", "Se hallo " + list.size() + " reserva");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}

	@GetMapping("/listDisponible")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listReservaDisponibles() {

		Map<String, Object> salida = new HashMap<>();

		try {
			List<reserva> list = reservaService.findAllByStateDisponible();
			if (CollectionUtils.isEmpty(list)) {
				salida.put("message", "No existen reserva disponibles");
			} else {
				salida.put("list", list);
				salida.put("message", "Se hallo " + list.size() + " reserva disponibles");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}

	@GetMapping("/{dni}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getreserva(@PathVariable("id") String id) {

		Map<String, Object> salida = new HashMap<>();
		
		try {
			Reserva hab = reservaService.getreserva(id);
			if (hab == null) {
				salida.put("message", "No existe la reserva con el dni " + dni);
			} else {
				salida.put("data", hab);
				salida.put("message", "reserva encontrado");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}

	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> createreserva(@RequestBody reserva res) {

		Map<String, Object> salida = new HashMap<>();
		
		try {
			reserva objres = reservaService.createreserva(res);
			if (objres == null) {
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
	public ResponseEntity<Map<String, Object>> updatereserva(@RequestBody reserva res) {

		Map<String, Object> salida = new HashMap<>();
		
		try {
			reserva objres = reservaService.updatereserva(res);
			if (objHab == null) {
				salida.put("message", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("data", objres);
				salida.put("message", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("message", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@DeleteMapping("/delete/{dni}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deletereserva(@PathVariable("dni") String dni) {

		Map<String, Object> salida = new HashMap<>();
		
		try {
			reserva objres = reservaService.deletereserva(dni);
			if (objHab == null) {
				salida.put("message", Constantes.MENSAJE_ELI_NO_EXISTE_ID);
			} else {
				salida.put("data", objres);
				salida.put("message", Constantes.MENSAJE_ELI_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("message", Constantes.MENSAJE_ELI_ERROR_ADM);
		}
		return ResponseEntity.ok(salida);

	}

}
