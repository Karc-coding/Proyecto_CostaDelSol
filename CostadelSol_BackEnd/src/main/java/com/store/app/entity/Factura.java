package com.store.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "factura")
public class Factura {

	@Id
	@Column(name = "Num_Fac")
	private String numFactura;
	
	@Column(name = "RUC")
	private String ruc;
	
	@Column(name = "DNI")
	private String dni;
	
	@JoinColumn(name = "Habitacion_ID")
	@Column(name = "Habitacion_ID")
	private String habitacionId;
	
	@JoinColumn(name = "Empleado_ID")
	@Column(name = "Empleado_ID")
	private String empleadoId;
	
	@Column(name = "Pre_Noche")
	private Double precioNoche;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Fec_Act")
	private Date fec_Act;
	
}
