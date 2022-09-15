package com.registro.usuarios.orden;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.categoria.Proveedor;
import com.registro.usuarios.categoria.ProveedorRepository;
import com.registro.usuarios.producto.Producto;
import com.registro.usuarios.producto.ProductoRepository;

@Controller
public class OrdenController {

	@Autowired
	private OrdenRepository ordenRepository;
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Autowired ProductoRepository productoRepository;
	
	@GetMapping("orden/nuevo")
	public String mostrarFormularioDeNuevaOrden(Model modelo) {
		List<Proveedor> ListaProveedor = proveedorRepository.findAll();
		List<Producto> ListaProducto = productoRepository.findAll();
		
		modelo.addAttribute("orden",new Orden());
		modelo.addAttribute("ListaProveedor", ListaProveedor);
		modelo.addAttribute("ListaProducto",ListaProducto);

		return"orden_formulario";
		
	}
	
	@PostMapping("/orden/guardar")
	public String guardarOrden(Orden orden) {
		ordenRepository.save(orden);
		return "redirect:/orden";
	}
	
	@GetMapping("/orden")
	public String listarOrden(Model modelo) {
		List<Orden> listaOrden = ordenRepository.findAll();
		modelo.addAttribute("listaOrden",listaOrden);
		
		return"orden";
	}
	
	@GetMapping("/orden/editar/{id}")
	public String mostrarFormularioDeModificarOrden(@PathVariable("id") Integer id,Model modelo) {
		Orden orden = ordenRepository.findById(id).get();
		modelo.addAttribute("orden", orden);
		
		List<Proveedor> ListaProveedor = proveedorRepository.findAll();
		modelo.addAttribute("ListaProveedor", ListaProveedor);
		
		List<Producto> ListaProducto = productoRepository.findAll();
		modelo.addAttribute("ListaProducto",ListaProducto);
		
		return "orden_formulario";	
	}
	@GetMapping("/orden/eliminar/{id}")
	public String eliminarOrden(@PathVariable("id") Integer id,Model modelo) {
		ordenRepository.deleteById(id);
		return "redirect:/orden";
	}
	
}
