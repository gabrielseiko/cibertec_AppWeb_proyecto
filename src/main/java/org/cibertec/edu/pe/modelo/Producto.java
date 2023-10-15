package org.cibertec.edu.pe.modelo;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	private String IdProducto;
	private String Nombre;
	private String Descripcion;
	private int IdCategoria;
	private String Talla;
	private double Precio;
	private int Stock;
	private boolean Estado;
	
	public Producto() {
		
	}

	public Producto(String idProducto, String nombre, String descripcion, int idCategoria, String talla, double precio,
			int stock, boolean estado) {
	
		IdProducto = idProducto;
		Nombre = nombre;
		Descripcion = descripcion;
		IdCategoria = idCategoria;
		Talla = talla;
		Precio = precio;
		Stock = stock;
		Estado = estado;
	}

	public String getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(String idProducto) {
		IdProducto = idProducto;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}

	public String getTalla() {
		return Talla;
	}

	public void setTalla(String talla) {
		Talla = talla;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
	
}
