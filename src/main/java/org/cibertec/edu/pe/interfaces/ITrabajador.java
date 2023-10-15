package org.cibertec.edu.pe.interfaces;

import org.cibertec.edu.pe.modelo.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajador extends JpaRepository<Trabajador, String>{

}
