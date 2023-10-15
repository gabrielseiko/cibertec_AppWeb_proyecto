package org.cibertec.edu.pe.interfaces;

import org.cibertec.edu.pe.modelo.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBoleta extends JpaRepository<Boleta, String> {

}
