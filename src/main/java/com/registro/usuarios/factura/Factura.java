package com.registro.usuarios.factura;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.registro.usuarios.producto.Producto;

@Entity
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false)
	private Double iva;

	@Column(length = 45, nullable = false)
	private String fechFactura;

	@Column(length = 45, nullable = false)
	private String totalFactura;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;

//	@ManyToOne
//	@JoinColumn(name = "formPago_id")
//	private frmPago formPago;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechFactura() {
		return fechFactura;
	}

	public void setFechFactura(String fechFactura) {
		this.fechFactura = fechFactura;
	}

	public String getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(String totalFactura) {
		this.totalFactura = totalFactura;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Factura(Integer id, Double iva, String fechFactura, String totalFactura, Producto producto) {
		super();
		this.id = id;
		this.iva = iva;
		this.fechFactura = fechFactura;
		this.totalFactura = totalFactura;
		this.producto = producto;
	}

	public Factura() {
		super();
	}

	public Factura(Double iva, String fechFactura, String totalFactura, Producto producto) {
		super();
		this.iva = iva;
		this.fechFactura = fechFactura;
		this.totalFactura = totalFactura;
		this.producto = producto;
	}

	public Factura(Integer id) {
		super();
		this.id = id;
	}

}
