package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IProductoService;
import org.cibertec.edu.pe.interfaceService.ITrabajadorService;
import org.cibertec.edu.pe.interfaces.ITrabajador;
import org.cibertec.edu.pe.modelo.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TrabajadorController {
	
	@Autowired
	private ITrabajadorService servicio;
	
	// Método para Listar
	@GetMapping("/listar")   // http://localhost:8080/listar
	public String Listar(Model m) {
		List<Trabajador> lista = servicio.ListadoTra();
		m.addAttribute("trabajadores", lista);
		return "listarTrabajadores";  // listarTrabajadores.html
	}
	
	// Método para Buscar
	@GetMapping("/ver/{id}")   // http://localhost:8080/ver/1
	public String ver(@PathVariable String id, Model m) {
		Optional<Trabajador> t = servicio.BuscarTra(id);
		m.addAttribute("trabajador", t);
		return "view";   // view.html
	}
	
	// Método para agregar
	@GetMapping("/nuevo")
	public String agregar(Model m) {
		m.addAttribute("trabajador", new Trabajador());
		return "form";   // form.html
	}
	
	// Método para editar
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable String id, Model m) {
		Optional<Trabajador> t = servicio.BuscarTra(id);
		m.addAttribute("trabajador", t);
		return "form";   // form.html
		
	}
												
	// Método para grabar
	@GetMapping("/salvar")
	public String salvar(@Validated Trabajador t, Model m) {
		servicio.Grabar(t);
		return "redirect:/listar";
	}
	
	// Método para suprimir
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable String id, Model m) {
		servicio.Suprimir(id);
		return "redirect:/listar";   
	}
}
