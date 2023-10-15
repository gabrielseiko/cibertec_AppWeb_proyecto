package org.cibertec.edu.pe.interfaces;

import org.cibertec.edu.pe.modelo.DetalleBoleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleBoleta extends JpaRepository<DetalleBoleta, String>{

}
