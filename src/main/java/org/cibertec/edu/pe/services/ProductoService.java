package org.cibertec.edu.pe.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.cibertec.edu.pe.model.Producto;
import org.cibertec.edu.pe.repository.IProductoRepository;
import org.cibertec.edu.pe.repositoryService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	private IProductoRepository data;
	


	@Override
	public List<Producto> ListadoProductos() {
		return (List<Producto>) data.findAll();
	}

	@Override
	public Optional<Producto> BuscarProducto(int id) {
		return data.findById(id);
	}

	@Override
	public int Grabar(Producto objP) {
		int rpta = 0;
		Producto p = data.save(objP);
		if (!p.equals(null))
			rpta = 1;
		return rpta;
	}

	@Override
	public void Suprimir(int id) {
		for (Producto p : ListadoProductos()) {
			if (p.getIdProducto() == id) {
				p.setEstado(false);
				Grabar(p);
				break;
			}
		}

	}
	
	@Transactional
    public List<Producto> ListadoProductosDisponibles() throws Exception{
        try {
            List<Producto> entities = this.data.ListadoProductosDisponibles();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

	@Override
	public List<Producto> buscarPorCategoria(String NombreCate) {
		 return data.findByFiltrado(NombreCate);
	}
	
	//REDUCIR STOCK
	@Override
    @Transactional
    public void reducirStock(int idProducto, int cantidad) {
        Optional<Producto> optionalProducto = data.findById(idProducto);
        optionalProducto.ifPresent(producto -> {
            producto.reducirStock(cantidad);
            Grabar(producto);
        });
    }

}
