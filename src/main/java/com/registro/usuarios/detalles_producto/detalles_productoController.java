package com.registro.usuarios.detalles_producto;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.util.reportes.DetallesExporterExcel;

@Controller
public class detalles_productoController {
	@Autowired
	private Detalles_productoRepository detalles_productoRepository;
	@Autowired
	private DetallesproductoServicio  detallesproductoServicio;

	@GetMapping("/detalles_productos")
	public String listarDetalles_productos(Model modelo,@Param("palabraClave")String palabraClave) {
		List<Detalles_producto> listaDetalles_productos = detallesproductoServicio.listAll(palabraClave);
		modelo.addAttribute("listaDetalles_productos", listaDetalles_productos);
		modelo.addAttribute("palabraClave", palabraClave);
		return "detalles_productos";
	}
	@GetMapping("/detalles_productos/nuevo")
	public String mostrarFormularioNuevoDeDetalles_producto(Model modelo) {
		modelo.addAttribute("detalles_producto", new Detalles_producto());
		return "detalles_producto_formulario";
	}

	@PostMapping("/detalles_productos/guardar")
	public String guardarDetalles_producto(Detalles_producto detalles_producto) {
		detalles_productoRepository.save(detalles_producto);
		return "redirect:/detalles_productos";

	}

	@GetMapping("/detalles_productos/editar/{id}")
	public String MostrarFormularioModificarDetalles_producto(@PathVariable("id") Integer id, Model modelo) {
		Detalles_producto detalles_producto = detalles_productoRepository.findById(id).get();
		modelo.addAttribute("detalles_producto", detalles_producto);
		return "detalles_producto_formulario";
	}

	@GetMapping("/detalles_productos/eliminar/{id}")

	public String eliminarDetalles_producto(@PathVariable("id") Integer id, Model modelo) {
		detalles_productoRepository.deleteById(id);
		return "redirect:/detalles_productos";
	}
	@GetMapping("/exportarDetalles_productoExcel")
	public void exportarDetalle_productoEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Detalles producto_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<Detalles_producto> detalles_producto= detallesproductoServicio.getAllUser();
		
		DetallesExporterExcel exporter = new DetallesExporterExcel(detalles_producto);
		exporter.exportar(response);
	}

}