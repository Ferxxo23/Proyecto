package com.registro.usuarios.carrito;

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
public class CarritoController {

	@Autowired
	private CarritoRepository carritoRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@GetMapping("/carritos")
	public String ListarCarritos(Model modelo) {
		List<Carrito> ListarCarritos = carritoRepository.findAll();
		modelo.addAttribute("ListarCarritos", ListarCarritos);
		return "carritos";
	}

	@GetMapping("/carritos/nueva")
	public String MostrarFormularioDeCrearNuevoCarrito(Model modelo) {
		List<Producto> listaProductos = productoRepository.findAll();

		modelo.addAttribute("listaProductos", listaProductos);
		modelo.addAttribute("carrito", new Carrito());

		return "carrito_formulario";

	}
	
	@PostMapping("/carritos/guardar")
	public String GuardarCarrito(Carrito carrito) {
		carritoRepository.save(carrito);
		return "redirect:/";
	}
	
	@GetMapping("/carritos/editar/{id}")
	public String MostarFormularioDeModificarCarrito(@PathVariable("id") Integer id, Model modelo) {
		List<Producto> listaProductos =productoRepository.findAll();
		Carrito carrito =carritoRepository.findById(id).get();
		modelo.addAttribute("listaProductos", listaProductos);
		modelo.addAttribute("carrito", carrito);
		
		return "carrito_formulario";
	}
	
	@GetMapping("/carritos/eliminar/{id}")
	public String EliminarCarritos(@PathVariable("id") Integer id, Model modelo) {
		carritoRepository.deleteById(id);
		return "redirect:/carritos";
	}
}
