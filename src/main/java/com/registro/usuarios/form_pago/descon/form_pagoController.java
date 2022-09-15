package com.registro.usuarios.form_pago.descon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class form_pagoController {
	@Autowired
	private Form_pagoRepository   form_pagoRepository;
	
	@GetMapping("/form_pagos")
	public String listarForm_pagos(Model modelo) {
	List<Form_pago>	 listaForm_pagos = form_pagoRepository.findAll();
	modelo.addAttribute("listaForm_pagos", listaForm_pagos);
	return "form_pagos";
	}
	
	@GetMapping("/form_pagos/nuevo")
	public String mostrarFormularioDeNuevaForm_pago(Model modelo) {
		
		modelo.addAttribute("form_pago", new Form_pago());
		return "form_pago_formulario";
		
	}
	
	
	@PostMapping("/form_pagos/guardar")
	public String guardarForm_pago(Form_pago form_pago) {
	form_pagoRepository.save(form_pago);
	return "redirect:/form_pagos";
	}

	
	@GetMapping("/form_pagos/editar/{id}")
	public String mostrarFormularioDeModificarForm_pago(@PathVariable("id") Integer id,Model modelo) {
		
		Form_pago form_pago =form_pagoRepository.findById(id).get();
		modelo.addAttribute("form_pago", form_pago);
		return "form_pago_formulario";
	}
	
	@GetMapping("/form_pagos/eliminar/{id}")
	
public String eliminarForm_pago(@PathVariable("id") Integer id,Model modelo) {
		form_pagoRepository.deleteById(id);
	
		return "redirect:/form_pagos";
	}
	
	
	
}
