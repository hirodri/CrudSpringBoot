package com.proyecto.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codPersona;
	private int cedula;
	private String nombre;
	private String apellido;
	private String tipoPersona;

	public Persona() {
		super();
	}

	public Persona(int codPersona, int cedula, String nombre, String apellido, String tipoPersona) {
		super();
		this.codPersona = codPersona;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoPersona = tipoPersona;
	}

	public int getCodPersona() {
		return codPersona;
	}

	public void setCodPersona(int codPersona) {
		this.codPersona = codPersona;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

}
