package com.registro.usuarios.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.detalles_producto.Detalles_producto;
import com.registro.usuarios.detalles_producto.Detalles_productoRepository;


@Controller
public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private Detalles_productoRepository detalles_productoRepository;
	
	
	@GetMapping("productos/nuevo")
	public String mostrarFormularioDeNuevoProducto(Model modelo) {
		
		List<Detalles_producto> listaDetalles_productos =detalles_productoRepository.findAll();     
		
		
		
		
		
	modelo.addAttribute("producto", new Producto());
	
	modelo.addAttribute("listaDetalles_productos", listaDetalles_productos);
	
	
	return "producto_formulario";
	}
	
	@PostMapping("/productos/guardar")
	public String guardarProducto(Producto producto) {
	productoRepository.save(producto);
	return "redirect:/";
	}
	
	@GetMapping("/productos")
	public String listarProductos(Model modelo) {
	List<Producto> listaProductos =productoRepository.findAll();
	modelo.addAttribute("listaProductos", listaProductos);
	
	return "productos";	
	}
	
	@GetMapping("/productos/editar/{id}")
	public String mostrarFormularioDeModificarProducto(@PathVariable("id") Integer id,Model modelo) {
	Producto producto= productoRepository.findById(id).get();
	modelo.addAttribute("producto", producto);
	
	List<Detalles_producto> listaDetalles_productos = detalles_productoRepository.findAll();
	modelo.addAttribute("listaDetalles_productos", listaDetalles_productos);
	
	return "producto_formulario";
	}
	
	@GetMapping("/productos/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id")Integer id, Model modelo) {
		productoRepository.deleteById(id);
		return "redirect:/productos";
		
	}
	
	
	
}
