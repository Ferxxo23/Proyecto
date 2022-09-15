package com.registro.usuarios.carrito;

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
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany
	@JoinColumn(name = "carrito_id")
	private List<Producto> productos = new ArrayList<>();

	@Column(length = 50, nullable = false, unique = false)
	private Integer cantidad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Carrito(Integer id, List<Producto> productos, Integer cantidad) {
		super();
		this.id = id;
		this.productos = productos;
		this.cantidad = cantidad;
	}

	public Carrito(List<Producto> productos, Integer cantidad) {
		super();
		this.productos = productos;
		this.cantidad = cantidad;
	}

	public Carrito() {
		super();
	}

}
