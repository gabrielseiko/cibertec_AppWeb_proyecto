package org.cibertec.edu.pe.repositoryService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Producto;




public interface IProductoService {

	public List<Producto> ListadoProductos();
	public Optional<Producto> BuscarProducto(int id);
	public int Grabar(Producto objP);
	public void Suprimir(int id);
	
	List<Producto> buscarPorNombreYCategoria(String Nombre, String NombreCate);
	
	
}
