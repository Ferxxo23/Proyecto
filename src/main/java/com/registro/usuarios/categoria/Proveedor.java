package com.registro.usuarios.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProveedor;
	
	@Column(length = 45, nullable = false)
	private String numDocumento;
	
	@Column(length = 45, nullable = false)
	private String nomProveedor;
	
	@Column(length = 45, nullable = false)
	private String telProveedor;
	
	@Column(length = 45, nullable = false)
	private String emailProveedor;

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}

	public String getTelProveedor() {
		return telProveedor;
	}

	public void setTelProveedor(String telProveedor) {
		this.telProveedor = telProveedor;
	}

	public String getEmailProveedor() {
		return emailProveedor;
	}

	public void setEmailProveedor(String emailProveedor) {
		this.emailProveedor = emailProveedor;
	}

	public Proveedor(String numDocumento, String nomProveedor, String telProveedor, String emailProveedor) {
		super();
		this.numDocumento = numDocumento;
		this.nomProveedor = nomProveedor;
		this.telProveedor = telProveedor;
		this.emailProveedor = emailProveedor;
	}

	public Proveedor(Integer idProveedor) {
		super();
		this.idProveedor = idProveedor;
	}
	public Proveedor() {
		super();
		}
	

	
	
}
