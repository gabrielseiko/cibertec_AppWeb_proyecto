package org.cibertec.edu.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trabajador")
public class Trabajador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdTrabajador")
	private int IdTrabajador;
	@Column(name = "Nombre")
	private String Nombre;
	@Column(name = "Apellido")
	private String Apellido;
	@Column(name = "DNI")
	private int DNI;
	@Column(name = "Telefono")
	private String Telefono;
	@Column(name = "Email")
	private String Email;
	@Column(name = "Estado")
	private boolean Estado;

	public Trabajador() {

	}

	public Trabajador(int idTrabajador, String nombre, String apellido, int dNI, String telefono, String email,
			boolean estado) {
		IdTrabajador = idTrabajador;
		Nombre = nombre;
		Apellido = apellido;
		DNI = dNI;
		Telefono = telefono;
		Email = email;
		Estado = estado;
	}

	public int getIdTrabajador() {
		return IdTrabajador;
	}

	public void setIdTrabajador(int idTrabajador) {
		IdTrabajador = idTrabajador;
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

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
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
