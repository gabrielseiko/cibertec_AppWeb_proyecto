package org.cibertec.edu.pe.repositoryService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Categoria;




public interface ICategoriaService {
	public List<Categoria> ListadoCategorias();
	public Optional<Categoria> BuscarCategoria(int id);
	public int Grabar(Categoria objC);
	public void Suprimir(int id);

}
