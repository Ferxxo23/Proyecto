package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.registro.usuarios.servicio.UsuarioServicio;
@Controller
public class admin {
	
	@GetMapping("/admin1")
	public String iniciarSesion() {
		return "principalAdmin";
	}
}
