package org.cibertec.edu.pe.services;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Boleta;
import org.cibertec.edu.pe.model.DetalleBoleta;
import org.cibertec.edu.pe.repository.IBoletaRepository;
import org.cibertec.edu.pe.repository.IDetalleBoletaRepository;
import org.cibertec.edu.pe.repositoryService.IBoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoletaService implements IBoletaService{

	@Autowired
	private IBoletaRepository data;
	@Autowired
	private IDetalleBoletaRepository dataDetalle;
	
	@Override
	public List<Boleta> ListadoVentas() {
		return (List<Boleta>) data.findAll();
	}

	@Override
	public Optional<Boleta> BuscarBol(int id) {
		return data.findById(id);
	}

	@Override
	public List<DetalleBoleta> obtenerDetallesPorBoleta(Boleta boleta) {
		return dataDetalle.findByBoleta(boleta);
	}

}
