package org.cibertec.edu.pe.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
	private int IdCategoria;
	private String Nombre;
	
	
	public Categoria() {
	}


	public Categoria(int idCategoria, String nombre) {
		IdCategoria = idCategoria;
		Nombre = nombre;
	}


	public int getIdCategoria() {
		return IdCategoria;
	}


	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	
	
	

}
