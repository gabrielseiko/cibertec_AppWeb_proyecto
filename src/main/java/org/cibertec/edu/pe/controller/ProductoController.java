package org.cibertec.edu.pe.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Categoria;
import org.cibertec.edu.pe.model.Producto;
import org.cibertec.edu.pe.repositoryService.ICategoriaService;
import org.cibertec.edu.pe.repositoryService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/productos")
@SessionAttributes({"producto"})
public class ProductoController {

	@Autowired
	private IProductoService servicio;
	
	@Autowired
	private ICategoriaService servicioCategoria;
	
	// Inicializacion del objeto Producto
	@ModelAttribute("producto")
	public Producto getProducto() {
		return new Producto();
	}

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
		List<Categoria> listaCat = servicioCategoria.ListadoCategorias();
		m.addAttribute("categorias", listaCat);
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
	
	// METODO PARA SUBIR IMAGEN
	@PostMapping("/subirImagen")
	public String subirImagen(@RequestParam("Imagen") MultipartFile file, @ModelAttribute("producto") Producto producto) {
		if (!file.isEmpty()) {
			try {
				// Obtén el nombre del archivo y genera una ruta donde guardar la imagen
				String fileName = file.getOriginalFilename();
				String uploadDirectory = "src/main/resources/static/img"; // Ruta donde se guardarán las imágenes
				String filePath = Paths.get(uploadDirectory, fileName).toString();

				// Guarda la imagen en el directorio especificado
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(bytes);
				stream.close();

				// Asigna la ruta de la imagen al libro
				producto.setImagen("/img/" + fileName); // Ajusta la ruta según tu estructura de carpetas

			} catch (Exception e) {
				// Manejo de errores, si la carga de la imagen falla
				e.printStackTrace();
			}
		}

		return "redirect:/productos/nuevo"; // Redirige al formulario de nuevo libro o a donde desees
	}
}
