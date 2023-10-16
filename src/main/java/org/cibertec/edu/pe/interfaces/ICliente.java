package org.cibertec.edu.pe.interfaces;

import org.cibertec.edu.pe.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICliente extends JpaRepository<Cliente, String> {

}
