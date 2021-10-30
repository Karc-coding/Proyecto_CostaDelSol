package com.store.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Reserva {
	
	private String dni;
	private String nombre;
	private String correo;
	private String habitacion;
	private int nroDias;
	private double descuento;
	
}
