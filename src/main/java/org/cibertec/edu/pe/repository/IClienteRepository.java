package org.cibertec.edu.pe.repository;

import org.cibertec.edu.pe.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

}
