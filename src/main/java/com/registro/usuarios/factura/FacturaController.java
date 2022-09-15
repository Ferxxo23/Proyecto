package com.registro.usuarios.factura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.producto.Producto;
import com.registro.usuarios.producto.ProductoRepository;



@Controller
public class FacturaController {

	
	@Autowired
	private FacturaRepository facturaRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("/facturas/nuevo")
	public String mostrarFormularioDeNuevaFactura(Model modelo) {
		List<Producto> listaProductos = productoRepository.findAll();
		modelo.addAttribute("factura", new Factura());
		modelo.addAttribute("listaProductos", listaProductos);
		 return "factura_formulario";
	}
	
	@PostMapping("/facturas/guardar")
	public String guardarFactura (Factura factura) {
		facturaRepository.save(factura);
		 return "redirect:/facturas";
		 
	}
	@GetMapping("/facturas")
	public String listarFacturas(Model modelo) {
		List<Factura> listaFacturas = facturaRepository.findAll();
		modelo.addAttribute("listaFacturas", listaFacturas);
		return "facturas";
	}
	
	@GetMapping("/facturas/editar/{id}")
	public String mostrarFormularioDeModificarfactura(@PathVariable("id") Integer id,Model modelo) {
		Factura factura = facturaRepository.findById(id).get();
		modelo.addAttribute("factura", factura);
		 
		List<Producto> listaProductos = productoRepository.findAll();
		modelo.addAttribute("listaProductos", listaProductos);
		
		return "factura_formulario";
		
	}
	
	@GetMapping("/facturas/eliminar/{id}")
	public String eliminarFactura (@PathVariable("id") Integer id, Model modelo) {
		facturaRepository.deleteById(id);
		return "redirect:/facturas";
	}
}
