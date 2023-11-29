package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Boleta;
import org.cibertec.edu.pe.model.Categoria;
import org.cibertec.edu.pe.model.Cliente;
import org.cibertec.edu.pe.model.DetalleBoleta;
import org.cibertec.edu.pe.model.Producto;
import org.cibertec.edu.pe.repositoryService.IBoletaService;
import org.cibertec.edu.pe.repositoryService.ICategoriaService;
import org.cibertec.edu.pe.repositoryService.IClienteService;
import org.cibertec.edu.pe.repositoryService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping
public class ControllerPDF {
	
	@Autowired
	private ICategoriaService servicioCat;	
	@Autowired
	private IClienteService servicioCli;
	@Autowired
	private IProductoService servicioPro;
	@Autowired
	private IBoletaService servicioBol;
	
	
	//Metodo para Productos
	@GetMapping("/PDFproductos")
	public String ListarProductos(Model m, @RequestParam(name = "format", required = false) String format) {
		List<Producto> lista = servicioPro.ListadoProductos();
		m.addAttribute("productos", lista);
			if("pdf".equals(format)) {
				return "PDFproductos"; // Asegúrate de que este sea el nombre correcto de tu vista PDF
			} else {
		return "PDFproductos"; // Cambia al nombre de tu vista HTML
		}
	}
	
	// Método para categoria
	@GetMapping("/PDFcategory")
	public String ListarCategoria(Model m,@RequestParam(name = "format", required = false) String format) {
	    System.out.println("Exporting to PDF...");
	    
	    List<Categoria> lista = servicioCat.ListadoCategorias();
	    m.addAttribute("categorias", lista);
	    if ("pdf".equals(format)) {
	        return "PDFcategory"; // Asegúrate de que este sea el nombre correcto de tu vista PDF
	    } else {
	        return "PDFcategory"; // Cambia al nombre de tu vista HTML
	    }
	   
	}
	
	// Método para categoria
		@GetMapping("/PDFcliente")
		public String ListarCliente(Model m,@RequestParam(name = "format", required = false) String format) {
		    System.out.println("Exporting to PDF...");
		    
		    List<Cliente> lista = servicioCli.ListadoClientes();
		    m.addAttribute("clientes", lista);
		    if ("pdf".equals(format)) {
		        return "PDFcliente"; // Asegúrate de que este sea el nombre correcto de tu vista PDF
		    } else {
		        return "PDFcliente"; // Cambia al nombre de tu vista HTML
		    }
		   
		}
		
	// NUEVO MÉTODO PARA VER BOLETA CON DETALLE
	  @GetMapping("/PDFboleta/{id}")
	  public String verConDetalle(@PathVariable int id, Model m) {
	      Optional<Boleta> boletaOptional = servicioBol.BuscarBol(id);
	      if (boletaOptional.isPresent()) {
	         Boleta boleta = boletaOptional.get();
	         List<DetalleBoleta> detalles = servicioBol.obtenerDetallesPorBoleta(boleta);
	          m.addAttribute("boleta", boleta);
	          m.addAttribute("detalles", detalles);
	          return "PDFboleta";
	      } else {
	          return "redirect:/PDFboleta";
	      }
	  }	

}
