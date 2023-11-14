package org.cibertec.edu.pe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.cibertec.edu.pe.model.Boleta;
import org.cibertec.edu.pe.model.DetalleBoleta;
import org.cibertec.edu.pe.model.Producto;
import org.cibertec.edu.pe.repository.IBoletaRepository;
import org.cibertec.edu.pe.repository.IDetalleBoletaRepository;
import org.cibertec.edu.pe.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "carrito", "total", "subtotal", "envio", "descuento" })
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

	// Inicializacion del objeto envio
	@ModelAttribute("envio")
	public double getEnvio() {
		return 0.0;
	}

	// Inicializacion del objeto descuento
	@ModelAttribute("descuento")
	public double getDescuento() {
		return 0.0;
	}

	// Declaracion e Inicializacion de objetos para el control del carrito de
	// compras
	@Autowired
	private IProductoRepository productoRepository;

	@Autowired
	private IBoletaRepository ventaRepository;

	@Autowired
	private IDetalleBoletaRepository detalleRepository;

	// Método para visualizar los productos a vender
	@GetMapping("/index") // localhost:9090/index
	public String listado(Model model) {
		List<Producto> lista = new ArrayList<>();
		lista = productoRepository.findAll(); // Recuperar las filas de la tabla productos
		model.addAttribute("productos", lista);
		return "index";
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
		model.addAttribute("envio", 0.0);
		model.addAttribute("descuento", 0.0);
		model.addAttribute("carrito", carrito);
		return "redirect:/index";
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
		model.addAttribute("envio", 0.0);
		model.addAttribute("descuento", 0.0);
		model.addAttribute("total", total);

		// Redirigir a la página del carrito
		return "redirect:/carrito";
	}

	// Método para registrar venta
	@PostMapping("/pagar")
	public String procesarPago(Model model) {

		Boleta nuevaVenta = new Boleta();
		nuevaVenta.setFecha(new Date()); //

		List<DetalleBoleta> carrito = (List<DetalleBoleta>) model.getAttribute("carrito");
		double total = (double) model.getAttribute("total");
		nuevaVenta.setTotal(total);
		Boleta ventaGuardada = ventaRepository.save(nuevaVenta);

		for (DetalleBoleta detalle : carrito) {
			detalle.setBoleta(ventaGuardada);
			detalleRepository.save(detalle);
		}

		// Limpia el carrito después de realizar la compra
		carrito.clear();
		model.addAttribute("subtotal", 0.0);
		model.addAttribute("envio", 0.0);
		model.addAttribute("descuento", 0.0);
		model.addAttribute("total", 0.0);

		return "redirect:/index";
	}

	// Metodo para calcular envio y descuento
	@PostMapping("/actualizarCarrito")
	public String actualizarCarrito(Model model) {
		List<DetalleBoleta> carrito = (List<DetalleBoleta>) model.getAttribute("carrito");
		double subtotal = 0.0;
		double envio = 0.0;
		double descuento = 0.0;
		double total = 0.0;

		// Obteniendo el valor del monto subtotal
		subtotal = (double) model.getAttribute("subtotal");

		// Calculando envio
		envio = (3.5 / 100) * subtotal;

		// Calculando descuento
		if (subtotal >= 1500 && subtotal <= 2500)
			descuento = (3.7 / 100) * subtotal;
		else if (subtotal >= 2501 && subtotal <= 3500)
			descuento = (4.8 / 100) * subtotal;
		else if (subtotal >= 3501 && subtotal <= 4500)
			descuento = (5.7 / 100) * subtotal;
		else if (subtotal > 4500)
			descuento = (6.8 / 100) * subtotal;
		else
			descuento = 0.0;

		// Calculando el monto total
		total = subtotal + envio - descuento;

		// Guardar valores en la sesion y pasarlos a la vista
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("total", total);
		model.addAttribute("envio", envio);
		model.addAttribute("descuento", descuento);
		model.addAttribute("carrito", carrito);

		return "redirect:/carrito";
	}

}
