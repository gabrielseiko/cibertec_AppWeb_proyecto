package org.cibertec.edu.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdCliente")
	private int IdCliente;
	@Column(name = "Nombre")
	private String Nombre;
	@Column(name = "Apellido")
	private String Apellido;
	@Column(name = "DNI")
	private int DNI;
	@Column(name = "Email")
	private String Email;
	@Column(name = "Estado")
	private boolean Estado;

	public Cliente() {
	}

	public Cliente(int idCliente, String nombre, String apellido, int dNI, String email, boolean estado) {
		IdCliente = idCliente;
		Nombre = nombre;
		Apellido = apellido;
		DNI = dNI;
		Email = email;
		Estado = estado;
	}

	public int getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(int idCliente) {
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

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}

}
