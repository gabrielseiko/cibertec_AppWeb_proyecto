package org.cibertec.edu.pe.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.cibertec.edu.pe.interfaceService.ITrabajadorService;
import org.cibertec.edu.pe.interfaces.ITrabajador;
import org.cibertec.edu.pe.modelo.Producto;
import org.cibertec.edu.pe.modelo.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

@Service
public class TrabajadorService implements ITrabajadorService {

	@Autowired
	private ITrabajador data;

	@Override
	public List<Trabajador> ListadoTra() {
		return (List<Trabajador>)data.findAll();
	}

	@Override
	public Optional<Trabajador> BuscarTra(String id) {
		return data.findById(id);
	}

	@Override
	public int Grabar(Trabajador objT) {
		int rpta = 0;
		Trabajador p = data.save(objT);
		if(!p.equals(null))
			rpta = 1;
		return rpta;
	}

	@Override
	public void Suprimir(String id) {
		data.deleteById(id);
		
	}
	

}
