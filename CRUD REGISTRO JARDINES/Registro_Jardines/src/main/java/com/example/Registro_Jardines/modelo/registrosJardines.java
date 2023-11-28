package com.example.Registro_Jardines.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Registro_Jardin")
public class registrosJardines {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Identificador_Jardin")
	private int id;

	@Column(name = "Nombre_Jardin")
	private String nombre;

	@Column(name = "Direccion_j")
	private String direccion;

	@Column(name = "Estado")
	private String Estado;

	public registrosJardines() {
	}

	public registrosJardines(String nombre, String direccion, String Estado) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.Estado = Estado;
	}

	// Getters y Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String Estado) {
		this.Estado = Estado;
	}
}
