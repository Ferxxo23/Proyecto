package com.registro.usuarios.orden;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.registro.usuarios.categoria.Proveedor;
import com.registro.usuarios.producto.Producto;

@Entity
public class Orden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOrdendeCompra;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "proveedor_idProveedor")
	private Proveedor proveedor;

	@Column(length = 45, nullable = false)
	private String cantidad;

	@Column(length = 45, nullable = false)
	private String created_at;


	public Integer getIdOrdendeCompra() {
		return idOrdendeCompra;
	}

	public void setIdOrdendeCompra(Integer idOrdendeCompra) {
		this.idOrdendeCompra = idOrdendeCompra;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}


	public Orden() {
		super();
	}

	public Orden(Producto producto, Proveedor proveedor, String cantidad, String unidadDeMedida, String created_at,
			String updated_at) {
		super();
		this.producto = producto;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
		this.created_at = created_at;
	}

	public Orden(Integer idOrdendeCompra) {
		super();
		this.idOrdendeCompra = idOrdendeCompra;
	}

	

}
