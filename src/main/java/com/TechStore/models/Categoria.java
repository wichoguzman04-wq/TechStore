package com.TechStore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import java.util.List;

@Entity
@Table(name = "categorias") 
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	private String nomCategoria;
	private String descripcion;
	private boolean activo;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private List<TechStore> productos;
	
	public Categoria() {
	}
	
	// Getters y Setters
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNomCategoria() {
		return nomCategoria;
	}
	
	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public boolean isActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<TechStore> getProductos() {
		return productos;
	}

	public void setProductos(List<TechStore> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nomCategoria=" + nomCategoria + ", activo=" + activo + "]";
	}
}
