package com.registro.usuarios.detalles_producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallesproductoServicio {
	@Autowired
	private Detalles_productoRepository detalles_productoRepository;

	public List<Detalles_producto> getAllUser() {
		return detalles_productoRepository.findAll();

	}

	public List<Detalles_producto> listAll(String palabraClave) {
		if (palabraClave != null) {
			return detalles_productoRepository.findAll(palabraClave);
		}

		return detalles_productoRepository.findAll();
	}

	public void save(Detalles_producto detallesproducto) {
		detalles_productoRepository.save(detallesproducto);

	}

	public Detalles_producto get(Integer id) {
		return detalles_productoRepository.findById(id).get();

	}

	public void delete(Integer id) {
		detalles_productoRepository.deleteById(id);
	}

}
