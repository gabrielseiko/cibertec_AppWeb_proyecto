package org.cibertec.edu.pe.services;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.cibertec.edu.pe.model.Categoria;
import org.cibertec.edu.pe.model.Producto;
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
		for (Categoria c : ListadoCategorias()) {
			if (c.getIdCategoria() == id) {
				c.setEstado(false);
				Grabar(c);
				break;
			}
		}
	}

	@Transactional
    public List<Categoria> ListadoCategoriasDisponibles() throws Exception{
        try {
            List<Categoria> entities = this.data.ListadoCategoriasDisponibles();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
