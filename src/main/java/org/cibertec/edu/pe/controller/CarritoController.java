package org.cibertec.edu.pe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.cibertec.edu.pe.model.Boleta;
import org.cibertec.edu.pe.model.Categoria;
import org.cibertec.edu.pe.model.Cliente;
import org.cibertec.edu.pe.model.DetalleBoleta;
import org.cibertec.edu.pe.model.Producto;
import org.cibertec.edu.pe.repository.IBoletaRepository;
import org.cibertec.edu.pe.repository.ICategoriaRepository;
import org.cibertec.edu.pe.repository.IClienteRepository;
import org.cibertec.edu.pe.repository.IDetalleBoletaRepository;
import org.cibertec.edu.pe.repository.IProductoRepository;
import org.cibertec.edu.pe.repositoryService.ICategoriaService;
import org.cibertec.edu.pe.repositoryService.IClienteService;
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
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "carrito", "total", "subtotal", "descuento", "cliente", "cli" })
@RequestMapping
public class CarritoController {
	// Inicializacion del objeto carrito
	@ModelAttribute("carrito")
	public List<DetalleBoleta> getCarrito() {
		return new ArrayList<>();
	}

	// Inicializacion del objeto subtotal
	@ModelAttribute("subtotal")
	public double getSubtotal() {
		return 0.0;
	}

	// Inicializacion del objeto total
	@ModelAttribute("total")
	public double getTotal() {
		return 0.0;
	}

	// Inicializacion del objeto descuento
	@ModelAttribute("descuento")
	public double getDescuento() {
		return 0.0;
	}
	@ModelAttribute("cliente")
	public String getCliente() {
		return "";
	}
	

	// Declaracion e Inicializacion de objetos para el control del carrito de
	// compras
	@Autowired
	private IProductoRepository productoRepository;

	@Autowired
	private IBoletaRepository ventaRepository;

	@Autowired
	private IDetalleBoletaRepository detalleRepository;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IClienteService servicioCliente;
	
	@Autowired
	private IProductoService serviceProducto;

	@Autowired
	private ICategoriaRepository categoriaRepository;
	
	@Autowired
	private ICategoriaService serviceCategoria;
	
	//VISUALIZAR LOS PRODUCTOS EN EL INDEX
	@GetMapping("/index")
	public String listado(Model model) {
		List<Producto> lista = new ArrayList<>();
		lista = productoRepository.findAll();
		model.addAttribute("producto", lista);
		return "index";
	}
		
		@GetMapping("/mantenimiento") 
		public String mantenimiento(Model model) {
			return "mantenimiento";
		}
	
	// Método para visualizar los productos a vender
	@GetMapping("/venta") 
	public String listadoVenta(Model model) {
		// Agrega la lista de categorías al modelo
		List<Categoria> lista2 = new ArrayList<>();
		lista2 = serviceCategoria.ListadoCategorias(); 
		model.addAttribute("categorias", lista2);
		
		List<Producto> lista = new ArrayList<>();
		lista = productoRepository.findAll(); 
		model.addAttribute("productos", lista);
		return "venta";
	}

	// Método para agregar productos al carrito
	@GetMapping("/agregar/{idProducto}")
	public String agregar(Model model, @PathVariable(name = "idProducto", required = true) int idProducto) {
		Producto p = productoRepository.findById(idProducto).orElse(null);
		List<DetalleBoleta> carrito = (List<DetalleBoleta>) model.getAttribute("carrito");
		double total = 0.0;
		double subtotal = 0.0;
		boolean existe = false;
		DetalleBoleta detalle = new DetalleBoleta();
		if (p != null) {
			detalle.setProducto(p);
			detalle.setCantidad(1);
			detalle.setSubtotal(detalle.getProducto().getPrecio() * detalle.getCantidad());
		}
		// Si el carrito esta vacio
		if (carrito.size() == 0) {
			carrito.add(detalle);
		} else {
			for (DetalleBoleta d : carrito) {
				if (d.getProducto().getIdProducto() == p.getIdProducto()) {
					d.setCantidad(d.getCantidad() + 1);
					d.setSubtotal(d.getProducto().getPrecio() * d.getCantidad());
					existe = true;
				}
			}
			if (!existe)
				carrito.add(detalle);
		}
		// Calculando la suma de sub-totales
		for (DetalleBoleta d : carrito)
			subtotal += d.getSubtotal();
		total = subtotal;
		// Guardar valores en la sesion y pasarlos a la vista
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("total", total);
		model.addAttribute("descuento", 0.0);
		model.addAttribute("carrito", carrito);
		return "redirect:/carrito";
	}
	
	// Método para agregar productos al carrito DESDE VISTA DE PRODUCTO****S
		@GetMapping("/agregar")
		public String agregarVista(Model model, @RequestParam(name = "idProducto", required = true) int idProducto) {
			Producto p = productoRepository.findById(idProducto).orElse(null);
			List<DetalleBoleta> carrito = (List<DetalleBoleta>) model.getAttribute("carrito");
			double total = 0.0;
			double subtotal = 0.0;
			boolean existe = false;
			DetalleBoleta detalle = new DetalleBoleta();
			if (p != null) {
				detalle.setProducto(p);
				detalle.setCantidad(1);
				detalle.setSubtotal(detalle.getProducto().getPrecio() * detalle.getCantidad());
			}
			// Si el carrito esta vacio
			if (carrito.size() == 0) {
				carrito.add(detalle);
			} else {
				for (DetalleBoleta d : carrito) {
					if (d.getProducto().getIdProducto() == p.getIdProducto()) {
						d.setCantidad(d.getCantidad() + 1);
						d.setSubtotal(d.getProducto().getPrecio() * d.getCantidad());
						existe = true;
					}
				}
				if (!existe)
					carrito.add(detalle);
			}
			// Calculando la suma de sub-totales
			for (DetalleBoleta d : carrito)
				subtotal += d.getSubtotal();
			total = subtotal;
			// Guardar valores en la sesion y pasarlos a la vista
			model.addAttribute("subtotal", subtotal);
			model.addAttribute("total", total);
			model.addAttribute("descuento", 0.0);
			model.addAttribute("carrito", carrito);
			return "redirect:/carrito";
		}

	// Método para visualizar el carrito de compras
	@GetMapping("/carrito")
	public String carrito() {
		return "carrito";
	}

	// Método para eliminar productos del carrito
	@GetMapping("/eliminar/{idProducto}")
	public String eliminar(@PathVariable(name = "idProducto") int idProducto, Model model) {
		List<DetalleBoleta> carrito = (List<DetalleBoleta>) model.getAttribute("carrito");
		double total = 0.0;
		double subtotal = 0.0;

		for (DetalleBoleta detalle : carrito) {
			if (detalle.getProducto().getIdProducto() == idProducto) {
				carrito.remove(detalle);
				break;
			}
		}

		// Calculando la suma de sub-totales
		for (DetalleBoleta d : carrito) {
			subtotal += d.getSubtotal();
			total = subtotal;
		}

		// Guardar valores en la sesion y pasarlos a la vista
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("carrito", carrito);
		model.addAttribute("descuento", 0.0);
		model.addAttribute("total", total);

		// Redirigir a la página del carrito
		return "redirect:/carrito";
	}
	

	// Método para registrar venta
	@PostMapping("/pagar")
	public String procesarPago(Model model) {
	    try {
	        // Crear una nueva boleta
	        Boleta nuevaVenta = new Boleta();
	        nuevaVenta.setFecha(new Date());
	        
	        // Obtener el cliente de la sesión
	        Cliente cliente = (Cliente) model.getAttribute("cliente");
	        nuevaVenta.setCliente(cliente);

	        // Obtener el carrito de la sesión
	        List<DetalleBoleta> carrito = (List<DetalleBoleta>) model.getAttribute("carrito");
	        double total = (double) model.getAttribute("total");
	        double descuento = (double) model.getAttribute("descuento");
	        
	        // Establecer descuento y total en la boleta
	        nuevaVenta.setDescuento(descuento);
	        nuevaVenta.setTotal(total);

	        // Guardar la boleta en la base de datos
	        Boleta ventaGuardada = ventaRepository.save(nuevaVenta);

	        // Actualizar el stock de productos y guardar detalles de la boleta
	        for (DetalleBoleta detalle : carrito) {
	            Producto producto = detalle.getProducto();
	            int cantidadComprada = detalle.getCantidad();

	            // Verificar si hay suficiente stock
	            if (producto.getStock() >= cantidadComprada) {
	                // Actualizar el stock
	                producto.setStock(producto.getStock() - cantidadComprada);
	                // Guardar el producto actualizado en la base de datos
	                productoRepository.save(producto);
	            } else {
	                // Manejar la situación en la que no hay suficiente stock
	                throw new RuntimeException("No hay suficiente stock para el producto: " + producto.getNombre());
	            }

	            // Establecer la boleta en el detalle y guardar en la base de datos
	            detalle.setBoleta(ventaGuardada);
	            detalleRepository.save(detalle);
	        }

	        // Limpiar el carrito después de realizar la compra
	        carrito.clear();
	        model.addAttribute("subtotal", 0.0);
	        model.addAttribute("descuento", 0.0);
	        model.addAttribute("total", 0.0);

	        // Redirigir a la página principal
	        return "redirect:/index";
	    } catch (Exception e) {
	        // Manejar excepciones (por ejemplo, redirigir a una página de error)
	        return "error";
	    }
	}



	// Método para actualizar el carrito y calcular descuento
	@PostMapping("/actualizarCarrito")
	public String actualizarCarrito(Model model) {
	    List<DetalleBoleta> carrito = (List<DetalleBoleta>) model.getAttribute("carrito");
	    double subtotal = 0.0;
	    double descuento = 0.0;
	    double total = 0.0;

	    // Obteniendo el valor del monto subtotal
	    subtotal = (double) model.getAttribute("subtotal");

	    // Calculando descuento
	    if (subtotal > 100)
	        descuento = (20.0 / 100.0) * subtotal;
	    else
	        descuento = 0.0;

	    // Calculando el monto total
	    total = subtotal - descuento;

	    // Guardar valores en la sesión y pasarlos a la vista
	    model.addAttribute("subtotal", subtotal);
	    model.addAttribute("total", total);
	    model.addAttribute("descuento", descuento);
	    model.addAttribute("carrito", carrito);

	    return "redirect:/carrito";
	}


	// Método para Listar
	@GetMapping("/listarClientesCarrito")
	public String ListarClientes(Model m) {
		List<Cliente> lista = clienteRepository.ListadoClientesDisponibles();
		m.addAttribute("clientes", lista);
		return "seleccionarCliente";
	}

	// Método para seleccionar cliente
	@GetMapping("/seleccionar/{id}")
	public String seleccionarCliente(Model model, @PathVariable int id) {
		List<Cliente> listaCli = servicioCliente.ListadoClientes();
		model.addAttribute("clientes", listaCli);
		Cliente c = clienteRepository.findById(id).orElse(null);
		String cli = getCliente();
		cli = c.getNombre();
		model.addAttribute("cliente", c);
		model.addAttribute("cli", cli);
		return "redirect:/carrito";
	}
	

	//METODO PARA BUSCAR PRODUCTO POR CATEGORIA
	@GetMapping("/buscarProducto")
	public String buscarProducto(@RequestParam("NombreCate") String NombreCate, Model model) {
	    List<Producto> productos = serviceProducto.buscarPorCategoria(NombreCate);
	    List<Categoria> lista2 = serviceCategoria.ListadoCategorias();  // Agrega esta línea para obtener la lista de categorías
	    model.addAttribute("productos", productos);
	    model.addAttribute("categorias", lista2);  // Agrega las categorías al modelo
	    return "venta";
	}

	

}
