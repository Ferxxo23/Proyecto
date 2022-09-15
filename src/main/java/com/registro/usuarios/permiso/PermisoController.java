package com.registro.usuarios.permiso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PermisoController {
	@Autowired
	private PermisoRepository permisoRepository;

	@GetMapping("/permisos")
	public String listarPermisos(Model modelo) {
		List<Permiso> listaPermisos = permisoRepository.findAll();
		modelo.addAttribute("listaPermisos", listaPermisos);
		return "permisos";

	}
	@GetMapping("/permisos/nuevo")

	public String mostrarFormularioDeNuevoPermiso(Model modelo) {
		modelo.addAttribute("permiso", new Permiso());
		return "permiso_formulario";
	}

	@PostMapping("/permisos/guardar")
	public String guardarPermiso(Permiso permiso) {
		permisoRepository.save(permiso);
		return "redirect:/permisos";
	}

	@GetMapping("/permisos/editar/{id}")
	public String mostrarFormularioDeModificarPermiso(@PathVariable("id") Integer id, Model modelo) {
		Permiso permiso = permisoRepository.findById(id).get();
		modelo.addAttribute("permiso", permiso);
		return "permiso_formulario";

	}

	@GetMapping("/permisos/eliminar/{id}")
	public String eliminarCatalogo_producto(@PathVariable("id") Integer id, Model modelo) {
		permisoRepository.deleteById(id);
		return "redirect:/permisos";
	}

}
