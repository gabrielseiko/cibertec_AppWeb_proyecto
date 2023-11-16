package org.cibertec.edu.pe.repository;

import java.util.List;

import org.cibertec.edu.pe.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

	@Query(value = "SELECT * FROM categoria  WHERE estado = '1' ", nativeQuery = true)
    List<Categoria> ListadoCategoriasDisponibles();
}
