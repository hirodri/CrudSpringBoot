package com.proyecto.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proyecto.demo.interfaceService.IemergenciaService;
import com.proyecto.demo.interfaceService.IpersonaService;
import com.proyecto.demo.modelo.Emergencia;
import com.proyecto.demo.modelo.Persona;

@Controller
@RequestMapping
public class ControladorEmergencia {

	@Autowired
	private IemergenciaService service;
	@Autowired
	private IpersonaService servic;
	
	@GetMapping("/Emergencia")
	public String listar(Model model) {
		List<Emergencia> emergencias=service.listar();
		model.addAttribute("emergencias",emergencias);
		return "indexEm";
	}
	@GetMapping ("/verPersona/{id}")
	public String verPersona(@PathVariable int id,  Model model) {
		
		Optional<Persona> persona = servic.listarId(id);		
		model.addAttribute("persona",persona);
		return "formEm";
	}
	
	@Autowired
	private IpersonaService ser;
	@RequestMapping("/")
	@ResponseBody
	public List<Persona> listaPersona(){
		return ser.listar();
	}
	
}
