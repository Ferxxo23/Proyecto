package com.registro.usuarios.detalles_producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Detalles_producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = false)
	private String Categoria;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	
	

	public Detalles_producto(Integer id, String categoria) {
		super();
		this.id = id;
		Categoria = categoria;
	}

	public Detalles_producto(Integer id) {
		super();
		this.id = id;
	}
	public Detalles_producto() {
		super();
	}

} 
