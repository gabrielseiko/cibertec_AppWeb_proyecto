package org.cibertec.edu.pe.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalleBoleta")
public class DetalleBoleta {

	@Id
	private String IdDetalle;
	private String IdProducto;
	private String NombrePro;
	private double PrecioUni;
	private int Cantidad;
	private double SubTotal;
	private String IdBoleta;
	
	public DetalleBoleta() {

	}

	public DetalleBoleta(String idDetalle, String idProducto, String nombrePro, double precioUni, int cantidad,
			double subTotal, String idBoleta) {
	
		IdDetalle = idDetalle;
		IdProducto = idProducto;
		NombrePro = nombrePro;
		PrecioUni = precioUni;
		Cantidad = cantidad;
		SubTotal = subTotal;
		IdBoleta = idBoleta;
	}

	public String getIdDetalle() {
		return IdDetalle;
	}

	public void setIdDetalle(String idDetalle) {
		IdDetalle = idDetalle;
	}

	public String getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(String idProducto) {
		IdProducto = idProducto;
	}

	public String getNombrePro() {
		return NombrePro;
	}

	public void setNombrePro(String nombrePro) {
		NombrePro = nombrePro;
	}

	public double getPrecioUni() {
		return PrecioUni;
	}

	public void setPrecioUni(double precioUni) {
		PrecioUni = precioUni;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public double getSubTotal() {
		return SubTotal;
	}

	public void setSubTotal(double subTotal) {
		SubTotal = subTotal;
	}

	public String getIdBoleta() {
		return IdBoleta;
	}

	public void setIdBoleta(String idBoleta) {
		IdBoleta = idBoleta;
	}
	
	
}
