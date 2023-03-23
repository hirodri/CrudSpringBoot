package com.proyecto.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.demo.modelo.Emergencia;

@Repository
public interface IEmergencia extends CrudRepository<Emergencia, Integer > {

}
