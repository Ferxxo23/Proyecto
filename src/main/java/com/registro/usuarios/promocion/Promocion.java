		package com.registro.usuarios.promocion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.registro.usuarios.producto.Producto;



@Entity
public class Promocion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50, nullable = false, unique = true)
	private String fecha_promocion;

	@Column(length = 50, nullable = false, unique = true)
	private String descripcion;

	@Column(length = 50, nullable = false, unique = true)
	private String create_at;

	@Column(length = 50, nullable = false, unique = true)
	private String update_at;

	@OneToMany
	@JoinColumn(name = "promocion_id")
	private List<Producto> productos = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFecha_promocion() {
		return fecha_promocion;
	}

	public void setFecha_promocion(String fecha_promocion) {
		this.fecha_promocion = fecha_promocion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}

	public String getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}

	

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	

	public Promocion(Integer id, String fecha_promocion, String descripcion, String create_at, String update_at,
			List<Producto> productos) {
		super();
		this.id = id;
		this.fecha_promocion = fecha_promocion;
		this.descripcion = descripcion;
		this.create_at = create_at;
		this.update_at = update_at;
		this.productos = productos;
	}

	

	public Promocion(String fecha_promocion, String descripcion, String create_at, String update_at,
			List<Producto> productos) {
		super();
		this.fecha_promocion = fecha_promocion;
		this.descripcion = descripcion;
		this.create_at = create_at;
		this.update_at = update_at;
		this.productos = productos;
	}

	public Promocion() {
		super();
	}

	
	
	
}
