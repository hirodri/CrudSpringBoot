package com.proyecto.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proyecto.demo.interfaceService.IemergenciaService;
import com.proyecto.demo.interfaceService.IpersonaService;
import com.proyecto.demo.modelo.Emergencia;
import com.proyecto.demo.modelo.Persona;

import jakarta.validation.Valid;

@Controller
@RequestMapping
public class ControladorEmergencia {

	@Autowired
	public IemergenciaService service;
	@Autowired
	public IpersonaService servic;
	
	@GetMapping("/emergencia")
	public String listar(Model model) {
		List<Emergencia> emergencias=service.listar();
		model.addAttribute("emergencias",emergencias);
		return "indexEm";
	}
	
	@GetMapping("/nuevaficha")
	public String agregar(Model model) {
		model.addAttribute("emergencia", new Emergencia());
		List<Persona> personas=servic.listar();
		for(Persona p :personas) {
			System.out.println(p.getNombre());
		}
		model.addAttribute("personas",personas);
		return "formEm";
	}
	@PostMapping ("/guardar")
	public String save(@Valid Emergencia e,Model model) {
		service.save(e);
		return "redirect:/emergencia";
	}
	
	@GetMapping ("/actualizar/{id}")
	public String editar(@PathVariable int id,  Model model) {
		Optional<Emergencia> emergencia = service.listarId(id);
		model.addAttribute("emergencia",emergencia);
		return "formEm";
	}
	
	
	@GetMapping ("/verPersona/{id}")
	public String verPersona(@PathVariable int id,  Model model) {		
		Optional<Persona> persona = servic.listarId(id);		
		model.addAttribute("persona",persona);
		return "formVista";
	}
	
	@GetMapping ("/lista")
	public String lista(Model model) {
		List<Persona> personas=servic.listar();
		model.addAttribute("personas",personas);
		return "formEm";
	}
	

}
