package org.cibertec.edu.pe.interfaceService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.modelo.Producto;

public interface IProductoService {

	public List<Producto> ListadoPro();
	public Optional<Producto> BuscarPro(String id);
	public int Grabar(Producto objP);
	public void Suprimir(String id);
	
}
