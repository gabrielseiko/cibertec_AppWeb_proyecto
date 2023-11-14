package org.cibertec.edu.pe.services;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Categoria;
import org.cibertec.edu.pe.model.Cliente;
import org.cibertec.edu.pe.repository.ICategoriaRepository;
import org.cibertec.edu.pe.repositoryService.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ICategoriaService{
	
	@Autowired
	private ICategoriaRepository data;

	@Override
	public List<Categoria> ListadoCategorias() {
		return (List<Categoria>)data.findAll();
	}

	@Override
	public Optional<Categoria> BuscarCategoria(int id) {
		return data.findById(id);
	}

	@Override
	public int Grabar(Categoria objC) {
		int rpta = 0;
		Categoria c = data.save(objC);
		if (!c.equals(null))
			rpta = 1;
		return rpta;
	}

	@Override
	public void Suprimir(int id) {
		Categoria cat = new Categoria();
		if(cat.getIdCategoria() == id) {
			cat.setEstado(false);
		}
	}

}
