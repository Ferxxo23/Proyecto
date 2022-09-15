package com.registro.usuarios.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProveedorController {
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@GetMapping("/proveedor")
	public String listarCategorias(Model modelo) {
		List<Proveedor> listaProveedor = proveedorRepository.findAll();
		modelo.addAttribute("listaProveedor",listaProveedor);
		return "proveedor";
	}
	
	@GetMapping("/proveedor/nuevo")
	public String mostrarFormularioDeNuevoProveedor(Model modelo) {
		modelo.addAttribute("proveedor",new Proveedor());
		return "proveedor_formulario";
	}
	
	@PostMapping("/proveedor/guardar")
	public String guardarProveedor(Proveedor proveedor) {
		proveedorRepository.save(proveedor);
		return "redirect:/proveedor";
	}
	
	@GetMapping("/proveedor/editar/{id}")
	public String mostrarFormularioDeModificarProveedor(@PathVariable("id") Integer id,Model modelo) {
		Proveedor proveedor = proveedorRepository.findById(id).get();
		modelo.addAttribute("proveedor", proveedor);
		
		return "proveedor_formulario";	
	}
	@GetMapping("/proveedor/eliminar/{id}")
	public String eliminarproveedor(@PathVariable("id") Integer id,Model modelo) {
		proveedorRepository.deleteById(id);
		return "redirect:/proveedor";
	}
}
