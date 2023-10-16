package org.cibertec.edu.pe.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	private String IdCliente;
	private String Nombre;
	private String Apellido;
	private int DNI;
	private String Email;
	
	public Cliente() {
	}

	public Cliente(String idCliente, String nombre, String apellido, int dNI, String email) {
		IdCliente = idCliente;
		Nombre = nombre;
		Apellido = apellido;
		DNI = dNI;
		Email = email;
	}

	public String getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(String idCliente) {
		IdCliente = idCliente;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
	
	
}
