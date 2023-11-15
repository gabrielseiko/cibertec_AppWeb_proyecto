package org.cibertec.edu.pe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "boleta")
public class Boleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdBoleta")
	private int IdBoleta;
	@Temporal(TemporalType.DATE)
	@Column(name = "Fecha")
	private Date Fecha;
	@ManyToOne
	@JoinColumn(name = "IdCliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "IdTrabajador")
	private Trabajador trabajador;
	@ManyToOne
	@JoinColumn(name = "IdProducto")
	private Producto producto;
	@Column(name = "Total")
	private double Total;
	@Column(name = "Estado")
	private boolean Estado;

	public Boleta() {

	}

	public Boleta(int idBoleta, Date fecha, Cliente cliente, Trabajador trabajador, Producto producto, double total,
			boolean estado) {
		IdBoleta = idBoleta;
		Fecha = fecha;
		this.cliente = cliente;
		this.trabajador = trabajador;
		this.producto = producto;
		Total = total;
		Estado = estado;
	}

	public int getIdBoleta() {
		return IdBoleta;
	}

	public void setIdBoleta(int idBoleta) {
		IdBoleta = idBoleta;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}

}
