package org.cibertec.edu.pe.services;

import java.util.List;

import org.cibertec.edu.pe.interfaceService.ICategoriaService;
import org.cibertec.edu.pe.interfaces.ICategoria;
import org.cibertec.edu.pe.modelo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ICategoriaService{
	
	@Autowired
	private ICategoria data;
	
	@Override
	public List<Categoria> ListadoCategoria() {
		return (List<Categoria>)data.findAll();

	}

}
