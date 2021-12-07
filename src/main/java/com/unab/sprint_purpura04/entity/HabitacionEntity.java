package com.unab.sprint_purpura04.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "habitacion")
public class HabitacionEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nhabitacion", length = 20, nullable = false)
	private String nhabitacion;
	
	@Column(name = "cantidad", length = 20, nullable = false)
	private String cantidad;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getnhabitacion() {
		return nhabitacion;
	}

	public void setnhabitacion(String nhabitacion) {
		this.nhabitacion = nhabitacion;
	}

	public String getcantidad() {
		return cantidad;
	}

	public void setcantidad(String cantidad) {
		this.cantidad = cantidad;
	}	
	
}
