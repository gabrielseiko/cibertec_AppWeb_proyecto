package org.cibertec.edu.pe.repositoryService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Boleta;





public interface IBoletaService {

	public List<Boleta> ListadoBol();
	public Optional<Boleta> BuscarBol(String id);
	public int Grabar(Boleta objB);
	public void Suprimir(String id);
}
