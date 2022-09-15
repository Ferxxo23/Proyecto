package com.registro.usuarios.producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.registro.usuarios.detalles_producto.Detalles_producto;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 128)
	private String nombre_Producto;

	@Column(length = 70)
	private String estado_Producto;

	@Column(length = 68)
	private Double Valor;

	@Column(length = 50)
	private Double Stock;

	@ManyToOne
	@JoinColumn(name = "detalles_producto_id")
	private Detalles_producto detalles_producto;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre_Producto() {
		return nombre_Producto;
	}

	public void setNombre_Producto(String nombre_Producto) {
		this.nombre_Producto = nombre_Producto;
	}

	public String getEstado_Producto() {
		return estado_Producto;
	}

	public void setEstado_Producto(String estado_Producto) {
		this.estado_Producto = estado_Producto;
	}

	public Double getValor() {
		return Valor;
	}

	public void setValor(Double valor) {
		Valor = valor;
	}

	public Double getStock() {
		return Stock;
	}

	public void setStock(Double stock) {
		Stock = stock;
	}

	public Detalles_producto getDetalles_producto() {
		return detalles_producto;
	}

	public void setDetalles_producto(Detalles_producto detalles_producto) {
		this.detalles_producto = detalles_producto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Producto(Integer id, String nombre_Producto, String estado_Producto, Double valor, Double stock,
			Detalles_producto detalles_producto, Producto producto) {
		super();
		this.id = id;
		this.nombre_Producto = nombre_Producto;
		this.estado_Producto = estado_Producto;
		Valor = valor;
		Stock = stock;
		this.detalles_producto = detalles_producto;
		this.producto = producto;
	}

	public Producto(Integer id) {
		super();
		this.id = id;
	}

	public Producto() {
		super();
	}

	public Producto(String nombre_Producto) {
		super();
		this.nombre_Producto = nombre_Producto;
	}

	@Override
	public String toString() {
		return nombre_Producto;
	}

}
