package com.registro.usuarios.persona;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 45,nullable = false)
	private String tipoDocUsuario;
	
	@Column(length = 45,nullable = false)
	private String num_documento;
	
	@Column(length = 45,nullable = false)
	private String nomUsuario;
	
	@Column(length = 45,nullable = false)
	private String apeUsuario;
	
	@Column(length = 45,nullable = false)
	private String telUsuario;
	
	@Column(length = 45,nullable = false)
	private String emailUsuario;
	
	@Column(length = 45,nullable = false)
	private String estadoUsuario;
	
	@Column(length = 45,nullable = false)
	private String created_at;
	
	@Column(length = 45,nullable = false)
	private String updated_at;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoDocUsuario() {
		return tipoDocUsuario;
	}

	public void setTipoDocUsuario(String tipoDocUsuario) {
		this.tipoDocUsuario = tipoDocUsuario;
	}

	public String getNum_documento() {
		return num_documento;
	}

	public void setNum_documento(String num_documento) {
		this.num_documento = num_documento;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getApeUsuario() {
		return apeUsuario;
	}

	public void setApeUsuario(String apeUsuario) {
		this.apeUsuario = apeUsuario;
	}

	public String getTelUsuario() {
		return telUsuario;
	}

	public void setTelUsuario(String telUsuario) {
		this.telUsuario = telUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public Persona() {
		super();
	}

	public Persona(Integer id, String tipoDocUsuario, String num_documento, String nomUsuario, String apeUsuario,
			String telUsuario, String emailUsuario, String estadoUsuario, String created_at, String updated_at) {
		super();
		this.id = id;
		this.tipoDocUsuario = tipoDocUsuario;
		this.num_documento = num_documento;
		this.nomUsuario = nomUsuario;
		this.apeUsuario = apeUsuario;
		this.telUsuario = telUsuario;
		this.emailUsuario = emailUsuario;
		this.estadoUsuario = estadoUsuario;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}


	
}
