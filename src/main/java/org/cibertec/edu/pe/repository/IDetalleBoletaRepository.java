package org.cibertec.edu.pe.repository;

import java.util.List;

import org.cibertec.edu.pe.model.Cliente;
import org.cibertec.edu.pe.model.DetalleBoleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleBoletaRepository extends JpaRepository<DetalleBoleta, Integer>{
	@Query(value = "SELECT * FROM detalle_boleta  WHERE id_boleta = ? ", nativeQuery = true)
    List<DetalleBoleta> ListadoDetalleBoleta(int id);

}
