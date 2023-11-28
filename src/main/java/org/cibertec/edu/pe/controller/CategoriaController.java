package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Categoria;
import org.cibertec.edu.pe.repositoryService.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaService servicio;

	// Método para Listar en Venta
	@GetMapping("/venta")
	public String ListarVenta(Model m) {
		List<Categoria> lista = servicio.ListadoCategorias();
		m.addAttribute("categorias", lista);
		return "venta";
	}
	
	// Método para Listar
	@GetMapping("/listar")
	public String Listar(Model m) {
		List<Categoria> lista = servicio.ListadoCategorias();
		m.addAttribute("categorias", lista);
		return "listarCategorias";
	}

	// Método para Buscar
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable int id, Model m) {
		Optional<Categoria> c = servicio.BuscarCategoria(id);
		m.addAttribute("categoria", c);
		return "viewCategoria";
	}

	// Método para agregar
	@GetMapping("/nuevo")
	public String agregar(Model m) {
		m.addAttribute("categoria", new Categoria());
		return "nuevoCategoria";
	}

	// Método para editar
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model m) {
		Optional<Categoria> c = servicio.BuscarCategoria(id);
		m.addAttribute("categoria", c);
		return "editarCategoria";

	}

	// Método para grabar
	@GetMapping("/salvar")
	public String salvar(@Validated Categoria c, Model m) {
		servicio.Grabar(c);
		return "redirect:/categorias/listar";
	}

	// Método para suprimir
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model m) {
		servicio.Suprimir(id);
		return "redirect:/categorias/listar";
	}
}
