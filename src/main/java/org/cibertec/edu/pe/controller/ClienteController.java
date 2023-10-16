package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IClienteService;
import org.cibertec.edu.pe.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ClienteController {
	
	@Autowired
	private IClienteService servicio;
	
	// Método para Listar
		@GetMapping("/listar") 
		public String Listar(Model m) {
			List<Cliente> lista = servicio.ListadoClient();
			m.addAttribute("cliente", lista);
			return "listarClientes";  
		}
		
		// Método para Buscar
		@GetMapping("/ver/{id}")  
		public String ver(@PathVariable String id, Model m) {
			Optional<Cliente> p = servicio.BuscarClient(id);
			m.addAttribute("Cliente", p);
			return "view";   
		}
		
		// Método para agregar
		@GetMapping("/nuevo")
		public String agregar(Model m) {
			m.addAttribute("Cliente", new Cliente());
			return "form"; 
		}
		
		// Método para editar
		@GetMapping("/editar/{id}")
		public String editar(@PathVariable String id, Model m) {
			Optional<Cliente> p = servicio.BuscarClient(id);
			m.addAttribute("Cliente", p);
			return "form";  
			
		}
													
		// Método para grabar
		@GetMapping("/salvar")
		public String salvar(@Validated Cliente p, Model m) {
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
