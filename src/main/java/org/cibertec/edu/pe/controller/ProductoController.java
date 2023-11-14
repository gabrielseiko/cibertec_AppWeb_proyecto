package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Producto;
import org.cibertec.edu.pe.repositoryService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService servicio;

	// Método para Listar
	@GetMapping("/listar")
	public String Listar(Model m) {
		List<Producto> lista = servicio.ListadoProductos();
		m.addAttribute("productos", lista);
		return "listarProductos";
	}

	// Método para Buscar
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable int id, Model m) {
		Optional<Producto> p = servicio.BuscarProducto(id);
		m.addAttribute("producto", p);
		return "viewProducto";
	}

	// Método para agregar
	@GetMapping("/nuevo")
	public String agregar(Model m) {
		m.addAttribute("producto", new Producto());
		return "nuevoProducto";
	}

	// Método para editar
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model m) {
		Optional<Producto> p = servicio.BuscarProducto(id);
		m.addAttribute("producto", p);
		return "editarProducto"; 

	}

	// Método para grabar
	@GetMapping("/salvar")
	public String salvar(@Validated Producto p, Model m) {
		servicio.Grabar(p);
		return "redirect:/productos/listar";
	}

	// Método para suprimir
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model m) {
		servicio.Suprimir(id);
		return "redirect:/productos/listar";
	}
}
