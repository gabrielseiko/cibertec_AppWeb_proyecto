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
	@Column(name = "Total")
	private double Total;
	

	public Boleta() {

	}

	public Boleta(int idBoleta, Date fecha, Cliente cliente, double total) {
		IdBoleta = idBoleta;
		Fecha = fecha;
		this.cliente = cliente;
		Total = total;
	
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

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}


}
