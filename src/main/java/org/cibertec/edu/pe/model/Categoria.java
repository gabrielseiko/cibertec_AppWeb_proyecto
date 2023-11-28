package org.cibertec.edu.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdCategoria")
	private int IdCategoria;
	
	@Column(name = "Nombre")
	private String NombreCate;
	
	@Column(name = "Estado")
	private boolean Estado;

	public Categoria() {
	
	}

	public Categoria(int idCategoria, String nombreCate, boolean estado) {
		
		IdCategoria = idCategoria;
		NombreCate = nombreCate;
		Estado = estado;
	}

	public int getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}

	public String getNombreCate() {
		return NombreCate;
	}

	public void setNombreCate(String nombreCate) {
		NombreCate = nombreCate;
	}

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}

	

}
