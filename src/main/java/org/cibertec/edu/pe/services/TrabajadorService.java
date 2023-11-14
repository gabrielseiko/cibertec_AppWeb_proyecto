package org.cibertec.edu.pe.services;

import java.util.List;
import java.util.Optional;


import org.cibertec.edu.pe.model.Trabajador;
import org.cibertec.edu.pe.repository.ITrabajadorRepository;
import org.cibertec.edu.pe.repositoryService.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TrabajadorService implements ITrabajadorService {

	@Autowired
	private ITrabajadorRepository data;

	@Override
	public List<Trabajador> ListadoTrabajadores() {
		return (List<Trabajador>) data.findAll();
	}

	@Override
	public Optional<Trabajador> BuscarTrabajador(int id) {
		return data.findById(id);
	}

	@Override
	public int Grabar(Trabajador objT) {
		int rpta = 0;
		Trabajador t = data.save(objT);
		if (!t.equals(null))
			rpta = 1;
		return rpta;
	}

	@Override
	public void Suprimir(int id) {
		data.deleteById(id);

	}

}
