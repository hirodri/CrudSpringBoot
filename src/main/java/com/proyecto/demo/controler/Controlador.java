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

import com.proyecto.demo.interfaceService.IpersonaService;
import com.proyecto.demo.modelo.Persona;

import jakarta.validation.Valid;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IpersonaService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Persona> personas=service.listar();
		model.addAttribute("personas",personas);
		return "index";
	}
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona", new Persona());
		return "form";
	}
	@PostMapping ("save")
	public String save(@Valid Persona p,Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	
	@GetMapping ("/editar/{id}")
	public String editar(@PathVariable int id,  Model model) {
		Optional<Persona> persona = service.listarId(id);
		model.addAttribute("persona",persona);
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delet(Model model,@PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}
	@GetMapping("/newEm")
	public String agregarEM(Model model) {
		model.addAttribute("persona", new Persona());
		return "formEmNew";
	}
}
