package org.cibertec.edu.pe.services;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IProductoService;
import org.cibertec.edu.pe.interfaces.IProducto;
import org.cibertec.edu.pe.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	private IProducto data;
	
	@Override
	public List<Producto> ListadoPro() {
		return (List<Producto>)data.findAll();
	}

	@Override
	public Optional<Producto> BuscarPro(String id) {
		return data.findById(id);
	}

	@Override
	public int Grabar(Producto objP) {
		
		int rpta = 0;
		Producto p = data.save(objP);
		if(!p.equals(null))
			rpta = 1;
		return rpta;
	}

	@Override
	public void Suprimir(String id) {
		data.deleteById(id);
	}

	
}
