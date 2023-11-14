package org.cibertec.edu.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleBoleta")
public class DetalleBoleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdDetalle")
	private int IdDetalle;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdProducto")
	@Column(name = "IdProducto")
	private Producto producto;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdBoleta")
	@Column(name = "IdBoleta")
	private Boleta boleta;
	@Column(name = "Cantidad")
	private int Cantidad;
	@Column(name = "Subtotal")
	private double Subtotal;

	public DetalleBoleta() {

	}

	public DetalleBoleta(int idDetalle, Producto producto, Boleta boleta, int cantidad, double subtotal) {
		IdDetalle = idDetalle;
		this.producto = producto;
		this.boleta = boleta;
		Cantidad = cantidad;
		Subtotal = subtotal;
	}

	public int getIdDetalle() {
		return IdDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		IdDetalle = idDetalle;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public double getSubtotal() {
		return Subtotal;
	}

	public void setSubtotal(double subtotal) {
		Subtotal = subtotal;
	}

}
