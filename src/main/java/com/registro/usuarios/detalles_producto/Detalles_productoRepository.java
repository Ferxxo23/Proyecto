package com.registro.usuarios.detalles_producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




public interface Detalles_productoRepository extends JpaRepository<Detalles_producto, Integer>{

	@Query("SELECT d FROM Detalles_producto d WHERE"
			+ " CONCAT(d.id,d.Categoria)"
		    +" LIKE %?1%")
	public List<Detalles_producto> findAll(String palabraClave);
}
