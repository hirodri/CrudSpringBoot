package com.proyecto.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.proyecto.demo.modelo.Persona;

public interface IpersonaService {
// creamos los metodos del crud
	
	public List<Persona> listar();
	public Optional<Persona> listarId(int id);
	public int save(Persona p);
	public void delete(int id);
}
