package org.cibertec.edu.pe.services;

import java.util.List;

import org.cibertec.edu.pe.model.Boleta;
import org.cibertec.edu.pe.repository.IBoletaRepository;
import org.cibertec.edu.pe.repositoryService.IBoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoletaService implements IBoletaService{

	@Autowired
	private IBoletaRepository data;
	
	@Override
	public List<Boleta> ListadoVentas() {
		return (List<Boleta>) data.findAll();
	}

}
