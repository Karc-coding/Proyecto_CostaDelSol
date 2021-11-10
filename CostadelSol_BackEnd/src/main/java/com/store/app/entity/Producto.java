package com.store.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Table(name = "Producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Producto_ID")
	private int idProducto;
	
	@Column(name = "Des_pro")
	private String descripcion;
	
	@Column(name = "Stock")
	private int stock;
	
	@Column(name = "Pre_Uni")
	private double preciouni;
	
	@JoinColumn(name = "Catpro_ID")
	@Column(name = "Catpro_ID")
	private String categoria;
}
