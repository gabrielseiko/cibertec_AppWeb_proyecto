package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Trabajador;
import org.cibertec.edu.pe.repositoryService.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {

	@Autowired
	private ITrabajadorService servicio;

	// Método para Listar
	@GetMapping("/listar")
	public String Listar(Model m) {
		List<Trabajador> lista = servicio.ListadoTrabajadores();
		m.addAttribute("trabajadores", lista);
		return "listarTrabajadores";
	}

	// Método para Buscar
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable int id, Model m) {
		Optional<Trabajador> t = servicio.BuscarTrabajador(id);
		m.addAttribute("trabajador", t);
		return "viewTrabajador";
	}

	// Método para agregar
	@GetMapping("/nuevo")
	public String agregar(Model m) {
		m.addAttribute("trabajador", new Trabajador());
		return "nuevoTrabajador";
	}

	// Método para editar
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model m) {
		Optional<Trabajador> t = servicio.BuscarTrabajador(id);
		m.addAttribute("trabajador", t);
		return "editarTrabajador";

	}

	// Método para grabar
	@GetMapping("/salvar")
	public String salvar(@Validated Trabajador t, Model m) {
		servicio.Grabar(t);
		return "redirect:/trabajadores/listar";
	}

	// Método para suprimir
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model m) {
		servicio.Suprimir(id);
		return "redirect:/trabajadores/listar";
	}
}
