package com.store.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserva")

public class Reserva {
	
	@Id
//	@Max(8)
	@Column(name = "reserva_dni", length = 8)
	private int dni;

	@NotNull
	@NotBlank
//	@Max(500)
	@Column(name = "Des_reserva", length = 250, nullable = false)
	private String description;

	@NotNull
	@NotBlank
//	@Max(100)
	@Column(name = "Est_reserva", length = 50, nullable = false)
	private String state;



}
