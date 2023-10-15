package org.cibertec.edu.pe.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="boleta")
public class Boleta {

	@Id
	private String IdBoleta;
	private String IdDetalle;
	private Date Fecha;
	private String IdCliente;
	private String IdTrabajador;
	private String IdProducto;
	private double Total;
	
	public Boleta() {
		
	}

	public Boleta(String idBoleta, String idDetalle, Date fecha, String idCliente, String idTrabajador,
			String idProducto, double total) {
	
		IdBoleta = idBoleta;
		IdDetalle = idDetalle;
		Fecha = fecha;
		IdCliente = idCliente;
		IdTrabajador = idTrabajador;
		IdProducto = idProducto;
		Total = total;
	}

	public String getIdBoleta() {
		return IdBoleta;
	}

	public void setIdBoleta(String idBoleta) {
		IdBoleta = idBoleta;
	}

	public String getIdDetalle() {
		return IdDetalle;
	}

	public void setIdDetalle(String idDetalle) {
		IdDetalle = idDetalle;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(String idCliente) {
		IdCliente = idCliente;
	}

	public String getIdTrabajador() {
		return IdTrabajador;
	}

	public void setIdTrabajador(String idTrabajador) {
		IdTrabajador = idTrabajador;
	}

	public String getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(String idProducto) {
		IdProducto = idProducto;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}
	
	
	
}
