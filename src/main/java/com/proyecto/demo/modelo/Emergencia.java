package com.proyecto.demo.modelo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emergencia")
public class Emergencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codEmergencia;
	private String titulo;
	private String descripcion;
	private Date fecha;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codPersona")
	private Persona personal;

	public int getCodEmergencia() {
		return codEmergencia;
	}

	public void setCodEmergencia(int codEmergencia) {
		this.codEmergencia = codEmergencia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Persona getPersonal() {
		return personal;
	}

	public void setPersonal(Persona personal) {
		this.personal = personal;
	}


	public Emergencia(int codEmergencia, String titulo, String descripcion, Date fecha, Persona personal) {
		super();
		this.codEmergencia = codEmergencia;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.personal = personal;
		
	}

	public Emergencia() {
		super();
	}

}
