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
	private Date fechaEmergencia;
	private Date fechaCreacion;
	private float latitud;
	
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

	public Persona getPersonal() {
		return personal;
	}

	public void setPersonal(Persona personal) {
		this.personal = personal;
	}

	public Date getFechaEmergencia() {
		return fechaEmergencia;
	}

	public void setFechaEmergencia(Date fechaEmergencia) {
		this.fechaEmergencia = fechaEmergencia;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public Emergencia(int codEmergencia, String titulo, String descripcion, Date fechaEmergencia, Date fechaCreacion,
			float latitud, Persona personal) {
		super();
		this.codEmergencia = codEmergencia;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaEmergencia = fechaEmergencia;
		this.fechaCreacion = fechaCreacion;
		this.latitud = latitud;
		this.personal = personal;
	}

	public Emergencia() {
		super();
	}

}
