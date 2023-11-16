package org.cibertec.edu.pe.repository;

import java.util.List;

import org.cibertec.edu.pe.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{

	@Query(value = "SELECT * FROM producto  WHERE estado = '1' ", nativeQuery = true)
    List<Producto> ListadoProductosDisponibles();
	
}
