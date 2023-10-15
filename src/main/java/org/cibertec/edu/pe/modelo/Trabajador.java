package org.cibertec.edu.pe.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trabajador")
public class Trabajador {

	@Id
	private String IdTrabajador;
	private String Nombre;
	private String Apellido;
	private String Dni;
	private String Telefono;
	private String Email;
	
	public Trabajador() {

	}

	public Trabajador(String idTrabajador, String nombre, String apellido, String dni, String telefono, String email) {

		IdTrabajador = idTrabajador;
		Nombre = nombre;
		Apellido = apellido;
		Dni = dni;
		Telefono = telefono;
		Email = email;
	}

	public String getIdTrabajador() {
		return IdTrabajador;
	}

	public void setIdTrabajador(String idTrabajador) {
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

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
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
	
	
}
