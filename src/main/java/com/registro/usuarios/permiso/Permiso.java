package com.registro.usuarios.permiso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Permiso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String decripcion;

	@ManyToOne
	@JoinColumn(name = "permiso_id")
	private Permiso permiso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDecripcion() {
		return decripcion;
	}

	public void setDecripcion(String decripcion) {
		this.decripcion = decripcion;
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public Permiso(Integer id, String decripcion, Permiso permiso) {
		super();
		this.id = id;
		this.decripcion = decripcion;
		this.permiso = permiso;
	}

	public Permiso(Integer id) {
		super();
		this.id = id;
	}

	public Permiso() {
		super();
	}

	@Override
	public String toString() {
		return decripcion;
	}
	
	

}
