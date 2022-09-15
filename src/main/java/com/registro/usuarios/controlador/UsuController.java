package com.registro.usuarios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.UsuarioRepositorio;
import com.registro.usuarios.servicio.UsuarioServicio;
@Controller
public class UsuController {
	
	@Autowired UsuarioRepositorio usuariosRepositorio;
	
	@GetMapping("/usua")
	public String listar(Model modelo) {
		List<Usuario> listaUsuarios = usuariosRepositorio.findAll();
		modelo.addAttribute("listaUsuarios",listaUsuarios);
		return "usua";
	}
}
