package org.cibertec.edu.pe.repository;

import java.util.List;

import org.cibertec.edu.pe.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajadorRepository extends JpaRepository<Trabajador, Integer>{

	@Query(value = "SELECT * FROM trabajador  WHERE estado = '1' ", nativeQuery = true)
    List<Trabajador> ListadoTrabajadoresDisponibles();
}
