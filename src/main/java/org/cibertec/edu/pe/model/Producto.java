package org.cibertec.edu.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdProducto")
	private int IdProducto;
	@Column(name = "Nombre")
	private String Nombre;
	@Column(name = "Descripcion")
	private String Descripcion;
	@ManyToOne
	@JoinColumn(name = "IdCategoria")
	private Categoria categoria;
	@Column(name = "Talla")
	private String Talla;
	@Column(name = "Precio")
	private double Precio;
	@Column(name = "Stock")
	private int Stock;
	@Column(name = "Imagen")
	private String Imagen;
	@Column(name = "Estado")
	private boolean Estado;
	
	public Producto() {
		
	}

	public Producto(int idProducto, String nombre, String descripcion, Categoria categoria, String talla, double precio,
			int stock, String imagen, boolean estado) {
		IdProducto = idProducto;
		Nombre = nombre;
		Descripcion = descripcion;
		this.categoria = categoria;
		Talla = talla;
		Precio = precio;
		Stock = stock;
		Imagen = imagen;
		Estado = estado;
	}



	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	
	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
	//METODO PARA REDUCIR STOCK DEL PRODUCTO CUANDO SE REALICE UNA VENTA
	public void reducirStock(int cantidad) {
        if (cantidad > 0 && this.Stock >= cantidad) {
            this.Stock -= cantidad;
        }
	}
}
