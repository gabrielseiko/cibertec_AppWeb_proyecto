package org.cibertec.edu.pe.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.cibertec.edu.pe.model.Categoria;
import org.cibertec.edu.pe.model.Producto;
import org.cibertec.edu.pe.repository.ICategoriaRepository;
import org.cibertec.edu.pe.repositoryService.ICategoriaService;
import org.cibertec.edu.pe.repositoryService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping
public class ProductoController {

	@Autowired
	private IProductoService servicio;

	@Autowired
	private ICategoriaService servicioCategoria;
	
	@Autowired
	private ICategoriaRepository categoriaRepository;

	// Inicializacion del objeto Producto
	@ModelAttribute("producto")
	public Producto getProducto() {
		return new Producto();
	}

	// Método para Listar
	@GetMapping("/listarProductos")
	public String Listar(Model m) {
		List<Producto> lista = servicio.ListadoProductos();
		m.addAttribute("productos", lista);
		return "listarProductos";
	}

	// Método para Buscar
	@GetMapping("/ver/producto/{id}")
	public String ver(@PathVariable int id, Model m) {
		List<Categoria> listaCat = servicioCategoria.ListadoCategorias();
		m.addAttribute("categorias", listaCat);
		Optional<Producto> p = servicio.BuscarProducto(id);
		m.addAttribute("producto", p);
		return "viewProducto";
	}

	// Método para agregar
	@GetMapping("/nuevoProducto")
	public String agregar(Model m) {
		List<Categoria> listaCat = categoriaRepository.ListadoCategoriasDisponibles();
		m.addAttribute("categorias", listaCat);
		m.addAttribute("producto", new Producto());
		return "nuevoProducto";
	}

	// Método para editar
	@GetMapping("/editar/producto/{id}")
	public String editar(@PathVariable int id, Model m) {
		List<Categoria> listaCat = servicioCategoria.ListadoCategorias();
		Optional<Producto> p = servicio.BuscarProducto(id);
		m.addAttribute("categorias", listaCat);
		m.addAttribute("producto", p);
		return "editarProducto";

	}

	

	// Método para suprimir
	@GetMapping("/eliminar/producto/{id}")
	public String eliminar(@PathVariable int id, Model m) {
		servicio.Suprimir(id);
		return "redirect:/listarProductos";
	}
	
	
	
	//METODO GUADAR NUEVO PRODUCTO
    @PostMapping("/salvarProducto" )
   public String salvar(Producto p, Model m, @RequestParam("file") MultipartFile imagen) {
    	
    	if(!imagen.isEmpty()) {
    		Path directorioImagenes = Paths.get("src//main//resources//static/img");
    		String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
    		
    		try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				
				p.setImagen(imagen.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	servicio.Grabar(p);
    	return "redirect:/listarProductos";
	}
	


	public boolean validarExtension(MultipartFile archivo) {
		try {
			ImageIO.read(archivo.getInputStream()).toString();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
