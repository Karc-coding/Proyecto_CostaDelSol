package com.store.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {

	@Id	
	private String reserva_ID;
	private String dni; 
	private String empleado_ID; 
	private String Habitacion_ID;
	private String Fec_Recerva; 
	private String Fec_Ingreso; 
	private String Fec_Salida;
		
}
