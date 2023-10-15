package org.cibertec.edu.pe.controller;

import org.cibertec.edu.pe.modelo.Producto;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProductoController {

	@Autowired
	private IProductoService servicio;
	
	// Método para Listar
	@GetMapping("/listar")   // http://localhost:8080/listar
	public String Listar(Model m) {
		List<Producto> lista = servicio.ListadoPro();
		m.addAttribute("productos", lista);
		return "listarProductos";  // listarProductos.html
	}
	
	// Método para Buscar
	@GetMapping("/ver/{id}")   // http://localhost:8080/ver/1
	public String ver(@PathVariable String id, Model m) {
		Optional<Producto> p = servicio.BuscarPro(id);
		m.addAttribute("producto", p);
		return "view";   // view.html
	}
	
	// Método para agregar
	@GetMapping("/nuevo")
	public String agregar(Model m) {
		m.addAttribute("producto", new Producto());
		return "form";   // form.html
	}
	
	// Método para editar
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable String id, Model m) {
		Optional<Producto> p = servicio.BuscarPro(id);
		m.addAttribute("producto", p);
		return "form";   // form.html
		
	}
												
	// Método para grabar
	@GetMapping("/salvar")
	public String salvar(@Validated Producto p, Model m) {
		servicio.Grabar(p);
		return "redirect:/listar";
	}
	
	// Método para suprimir
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable String id, Model m) {
		servicio.Suprimir(id);
		return "redirect:/listar";   
	}
}
