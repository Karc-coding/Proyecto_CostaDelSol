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
@Table(name = "Habitacion")
public class Habitacion {

	@Id
//	@Max(4)
	@Column(name = "Habitacion_ID", length = 4)
	private String id;

	@NotNull
	@NotBlank
//	@Max(250)
	@Column(name = "Des_Hab", length = 250, nullable = false)
	private String description;

	@NotNull
	@NotBlank
//	@Max(50)
	@Column(name = "Est_Hab", length = 50, nullable = false)
	private String state;

	@NotNull
	@Column(name = "Pre_Hab", scale = 2, precision = 9, nullable = false)
	private Double price;

}
