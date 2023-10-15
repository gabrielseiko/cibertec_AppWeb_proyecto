package org.cibertec.edu.pe.interfaceService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.modelo.Trabajador;


public interface ITrabajadorService {

	public List<Trabajador> ListadoTra();
	public Optional<Trabajador> BuscarTra(String id);
	public int Grabar(Trabajador objT);
	public void Suprimir(String id);
}
