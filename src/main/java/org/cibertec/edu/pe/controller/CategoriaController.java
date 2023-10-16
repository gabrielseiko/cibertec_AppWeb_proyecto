package org.cibertec.edu.pe.controller;

import java.util.List;

import org.cibertec.edu.pe.interfaceService.ICategoriaService;
import org.cibertec.edu.pe.modelo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CategoriaController {
	

	@Autowired
	private ICategoriaService servicio;
			// Método para Listar
			@GetMapping("/listar") 
			public String Listar(Model m) {
				List<Categoria> lista = servicio.ListadoCategoria();
				m.addAttribute("categoria", lista);
				return "listarCategoria";  
			}
			
			// Método para agregar
			@GetMapping("/nuevo")
			public String agregar(Model m) {
				m.addAttribute("categoria", new Categoria());
				return "form"; 
			}
}
