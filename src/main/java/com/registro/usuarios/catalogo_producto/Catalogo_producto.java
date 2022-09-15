package com.registro.usuarios.catalogo_producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.registro.usuarios.producto.Producto;


@Entity
public class Catalogo_producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String imagen_producto;

	@Column(length = 45, nullable = false, unique = true)
	private String descripcion_producto;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImagen_producto() {
		return imagen_producto;
	}

	public void setImagen_producto(String imagen_producto) {
		this.imagen_producto = imagen_producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Catalogo_producto(Integer id, String imagen_producto, String descripcion_producto, String nombre_Producto,
			float precio, String cantidad, Producto producto) {
		super();
		this.id = id;
		this.imagen_producto = imagen_producto;
		this.descripcion_producto = descripcion_producto;
		this.producto = producto;
	}

	public Catalogo_producto() {
		super();
	}

	public Catalogo_producto(String imagen_producto, String descripcion_producto, String nombre_Producto, float precio,
			String cantidad, Producto producto) {
		super();
		this.imagen_producto = imagen_producto;
		this.descripcion_producto = descripcion_producto;;
		this.producto = producto;
	}

	public Catalogo_producto(Integer id) {
		super();
		this.id = id;
	}
	

}
