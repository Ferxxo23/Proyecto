package com.registro.usuarios.promocion;

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
public class PromocionController {
	@Autowired
	private PromocionRepository promocionRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@GetMapping("/promociones")
	public String ListarPromociones(Model modelo) {
		List<Promocion> ListarPromociones = promocionRepository.findAll();
		modelo.addAttribute("ListarPromociones", ListarPromociones);
		return "promociones";
	}

	@GetMapping("/promociones/nueva")
	public String MostrarFormularioDeCrearNuevaPromocion(Model modelo) {
		List<Producto> listaProductos = productoRepository.findAll();

		modelo.addAttribute("listaProductos", listaProductos);
		modelo.addAttribute("promocion", new Promocion());

		return "promocion_formulario";

	}

	@PostMapping("/promociones/guardar")
	public String GuardarPromocion(Promocion promocion) {
		promocionRepository.save(promocion);
		return "redirect:/";
	}

	@GetMapping("/promociones/editar/{id}")
	public String MostrarFormularioDeModificarPromocion(@PathVariable("id") Integer id, Model modelo) {
		List<Producto> listaProductos = productoRepository.findAll();
		Promocion promocion = promocionRepository.findById(id).get();
		modelo.addAttribute("listaProductos", listaProductos);
		modelo.addAttribute("promocion", promocion);

		return "promocion_formulario";

	}

	@GetMapping("/promociones/eliminar/{id}")
	public String eliminarPromociones(@PathVariable("id") Integer id, Model modelo) {
		promocionRepository.deleteById(id);
		return "redirect:/promociones";
	}
}
