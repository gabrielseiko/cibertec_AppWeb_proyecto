package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Cliente;
import org.cibertec.edu.pe.repositoryService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService servicio;

	// Método para Listar
	@GetMapping("/listar")
	public String Listar(Model m) {
		List<Cliente> lista = servicio.ListadoClientes();
		m.addAttribute("clientes", lista);
		return "listarClientes";
	}

	// Método para Buscar
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable int id, Model m) {
		Optional<Cliente> c = servicio.BuscarCliente(id);
		m.addAttribute("cliente", c);
		return "viewCliente";
	}

	// Método para agregar
	@GetMapping("/nuevo")
	public String agregar(Model m) {
		m.addAttribute("cliente", new Cliente());
		return "nuevoCliente";
	}

	// Método para editar
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model m) {
		Optional<Cliente> c = servicio.BuscarCliente(id);
		m.addAttribute("cliente", c);
		return "editarCliente";

	}

	// Método para grabar
	@GetMapping("/salvar")
	public String salvar(@Validated Cliente c, Model m) {
		servicio.Grabar(c);
		return "redirect:/clientes/listar";
	}

	// Método para suprimir
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model m) {
		servicio.Suprimir(id);
		return "redirect:/clientes/listar";
	}

}
