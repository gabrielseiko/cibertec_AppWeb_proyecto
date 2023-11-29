package org.cibertec.edu.pe.repositoryService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Boleta;
import org.cibertec.edu.pe.model.DetalleBoleta;


public interface IBoletaService {
	public List<Boleta> ListadoVentas();
	public Optional<Boleta> BuscarBol(int id); 
	public List<DetalleBoleta> obtenerDetallesPorBoleta(Boleta boleta);
}
