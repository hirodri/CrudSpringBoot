package com.proyecto.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.interfaceService.IemergenciaService;
import com.proyecto.demo.interfaces.IEmergencia;
import com.proyecto.demo.modelo.Emergencia;

@Service
public class EmergenciaService implements IemergenciaService{

	@Autowired
	private IEmergencia data;
	@Override
	public List<Emergencia> listar() {
		return (List<Emergencia>)data.findAll();
	}

	@Override
	public Optional<Emergencia> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Emergencia e) {
		int res=0;
		Emergencia emergencia = data.save(e);		
		if(!emergencia.equals(null)) {
			res=1;
		}
		return 0;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
