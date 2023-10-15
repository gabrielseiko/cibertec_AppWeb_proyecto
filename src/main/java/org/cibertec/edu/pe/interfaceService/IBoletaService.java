package org.cibertec.edu.pe.interfaceService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.modelo.Boleta;



public interface IBoletaService {

	public List<Boleta> ListadoBol();
	public Optional<Boleta> BuscarBol(String id);
	public int Grabar(Boleta objB);
	public void Suprimir(String id);
}
