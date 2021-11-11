package com.store.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="Huesped")
public class Huesped {
	
	@Id
	@Column(name ="DNI")
	private String dni;
	@Column(name ="Nom_Hue")
	private String nombre;
	@Column(name ="Ape_Hue")
	private String apellido;
	@Column(name ="Tel_Hue")
	private String telefono;
	@Column(name ="Cor_Hue")
	private String correo;
	@Column(name ="Est_Hue")
	private String estado;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	

}

