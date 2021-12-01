package com.store.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Empleado")
public class Empleado {
	
	@Id
	@Column(name = "Empleado_ID", length = 4)
	private String id;
	
	@Column(name = "DNI", nullable = false)
	private String dni;
	
	@Column(name = "Nombre", nullable = false)
	private String nombre;
	
	@Column(name = "Apellidos", nullable = false)
	private String apellido;
	
	@Column(name = "Cargo", nullable = false)
	private String cargo;

}
