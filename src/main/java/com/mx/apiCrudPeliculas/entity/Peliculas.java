package com.mx.apiCrudPeliculas.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="PELICULAS")


public class Peliculas {

	
	
	/*CREATE TABLE PELICULAS(
ID NUMBER PRIMARY KEY,
NOMBRE VARCHAR(80) NOT NULL,
GENERO VARCHAR(50) NOT NULL,
FECHA_LANZ DATE,
PRECIO NUMBER
);
	 * 
	 */
	
	
	
	
	
	//Mapear los campos de la tabla
	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="GENERO")
	private String genero;
	@Column(name= "FECHA_LANZ")
	private Date fecha;
	@Column(name = "PRECIO")
	private Float precio;
	
	
	public Peliculas() {
	}


	public Peliculas(Long id, String nombre, String genero, Date fecha, Float precio) {
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.fecha = fecha;
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Peliculas [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", fecha=" + fecha + ", precio="
				+ precio + "]\n";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Float getPrecio() {
		return precio;
	}


	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
	
	
	
	
}
