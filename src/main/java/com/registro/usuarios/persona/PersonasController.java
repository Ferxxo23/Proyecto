package com.registro.usuarios.persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PersonasController {

	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping("/personas")
	public String listarPersonas(Model modelo) {
		
		List<Persona> listaPersonas = personaRepository.findAll();
		modelo.addAttribute("listaPersonas", listaPersonas);
		return "personas";
 	}
	
	@GetMapping("/personas/nuevo")
	public String mortrarFormularioDeNuevaPersona(Model modelo) {
		modelo.addAttribute("persona", new Persona());
		return "persona_formulario";
	}
	
	@PostMapping("/personas/guardar")
	public String guardarPersona (Persona persona) {
		personaRepository.save(persona);
		return "redirect:/personas";
	}
	
	@GetMapping("/personas/editar/{id}")
	public String mostrarFormularioDeModificarPersona(@PathVariable("id") Integer id,Model modelo) {
		Persona persona = personaRepository.findById(id).get();
		modelo.addAttribute("persona", persona);
		 
		
		
		return "persona_formulario";
		
	}
	
	@GetMapping("/personas/eliminar/{id}")
	public String eliminarPersona (@PathVariable("id") Integer id, Model modelo) {
		personaRepository.deleteById(id);
		return "redirect:/personas";
	}
}
