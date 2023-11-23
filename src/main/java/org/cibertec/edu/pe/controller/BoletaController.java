package org.cibertec.edu.pe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Boleta;
import org.cibertec.edu.pe.model.Categoria;
import org.cibertec.edu.pe.model.Cliente;
import org.cibertec.edu.pe.model.DetalleBoleta;
import org.cibertec.edu.pe.model.Producto;
import org.cibertec.edu.pe.repository.IClienteRepository;
import org.cibertec.edu.pe.repository.IDetalleBoletaRepository;
import org.cibertec.edu.pe.repositoryService.IBoletaService;
import org.cibertec.edu.pe.repositoryService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class BoletaController {

	@Autowired
	private IBoletaService servicioBoleta;
	
	@Autowired
	private IClienteService servicioCliente;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IDetalleBoletaRepository detalleRepository;
	
	@GetMapping("/listarVentas")
	public String ListarVentas(Model m) {
		List<Cliente> listaCli = servicioCliente.ListadoClientes();
		m.addAttribute("clientes", listaCli);
		
		List<Boleta> lista = servicioBoleta.ListadoVentas();
		m.addAttribute("ventas", lista);
		return "listarVentas";
	}

	// Método para Buscar
	@GetMapping("/verDetalle/{id}")
	public String verVentas(@PathVariable int id, Model m) {
		List<DetalleBoleta> lista = new ArrayList<>();
		lista = detalleRepository.ListadoDetalleBoleta(id);
		m.addAttribute("detalle", lista);
		return "viewDetalle";
	}
}
