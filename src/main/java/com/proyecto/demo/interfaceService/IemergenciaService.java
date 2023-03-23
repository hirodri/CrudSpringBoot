package com.proyecto.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.proyecto.demo.modelo.Emergencia;

public interface IemergenciaService {

	public List<Emergencia> listar();
	public Optional <Emergencia> listarId(int id);
	public int save(Emergencia e);
	public void delete(int id);
}
