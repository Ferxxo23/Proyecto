package com.registro.usuarios.catalogo_producto;


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
public class Catalogo_productoController {
@Autowired
private Catalogo_productoRepository  catalogo_productoRepository;

@Autowired

private ProductoRepository  productoRepository; 



@GetMapping("catalogo_productos/nuevo")

public String mostrarFormularioDeNuevoCatalogo_producto(Model modelo) {
	
	List<Producto> listaProductos = productoRepository.findAll();
	
	
modelo.addAttribute("catalogo_producto", new Catalogo_producto());	
modelo.addAttribute("listaProductos", listaProductos);

return "catalogo_producto_formulario";
}

@PostMapping("/catalogo_productos/guardar")
public String guardarCatalogo_producto(Catalogo_producto catalogo_producto) {
catalogo_productoRepository.save(catalogo_producto);
return "redirect:/";
}


@GetMapping("/catalogo_productos")
public String listarCatalogo_productos(Model modelo) {
	List<Catalogo_producto> listaCatalogo_productos=catalogo_productoRepository.findAll();
	modelo.addAttribute("listaCatalogo_productos", listaCatalogo_productos);
	
	return "catalogo_productos";
	
	
}
@GetMapping("/catalogo_productos/editar/{id}")
public String mostrarFormularioDeModificarCatalogo_producto(@PathVariable("id") Integer id,Model modelo) {
Catalogo_producto catalogo_producto= catalogo_productoRepository.findById(id).get();	
modelo.addAttribute("catalogo_producto", catalogo_producto);

List<Producto> listaProductos = productoRepository.findAll();


	
modelo.addAttribute("listaProductos", listaProductos);


return  "catalogo_producto_formulario";

}
@GetMapping("/catalogo_productos/eliminar/{id}")
public String eliminarCatalogo_producto(@PathVariable("id")Integer  id, Model modelo) {
catalogo_productoRepository.deleteById(id);
return "redirect:/catalogo_productos";
}


}
