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
@Table(name = "Producto")
public class Producto {

	@Id
//	@Max(4)
	@Column(name = "Producto_ID", length = 4)
	private String id;

	@NotNull
	@NotBlank
//	@Max(250)
	@Column(name = "Des_Pro", length = 250, nullable = false)
	private String description;

	@NotNull
	@Column(name = "Stock", scale = 2, precision = 9, nullable = false)
	private Double stock;
	
	@NotNull
	@Column(name = "Pre_Uni", scale = 2, precision = 9, nullable = false)
	private Double price;
	
//	@Max(4)
	@Column(name = "Catpro_ID", length = 1)
	private String idcat;
}
