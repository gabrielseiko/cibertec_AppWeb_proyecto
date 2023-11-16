package org.cibertec.edu.pe.repository;

import java.util.List;

import org.cibertec.edu.pe.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query(value = "SELECT * FROM cliente  WHERE estado = '1' ", nativeQuery = true)
    List<Cliente> ListadoClientesDisponibles();
}
