package com.registro.usuarios.form_pago.descon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Form_pago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45, nullable = false, unique = true)
	private String des_Pago;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDes_Pago() {
		return des_Pago;
	}

	public void setDes_Pago(String des_Pago) {
		this.des_Pago = des_Pago;
	}

	public Form_pago() {
		super();
	}

	public Form_pago(Integer id, String des_Pago) {
		super();
		this.id = id;
		this.des_Pago = des_Pago;
	}

	public Form_pago(Integer id) {
		super();
		this.id = id;
	}

	public Form_pago(String des_Pago) {
		super();
		this.des_Pago = des_Pago;
	}
	
	
	
	
}
