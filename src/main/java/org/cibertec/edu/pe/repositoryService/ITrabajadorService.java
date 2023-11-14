package org.cibertec.edu.pe.repositoryService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Trabajador;

;


public interface ITrabajadorService {

	public List<Trabajador> ListadoTrabajadores();
	public Optional<Trabajador> BuscarTrabajador(int id);
	public int Grabar(Trabajador objT);
	public void Suprimir(int id);
}
