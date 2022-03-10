package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.AsignaturaDTO;
import org.iesalixar.servidor.dto.ProfesorDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.DepartamentoServiceImpl;
import org.iesalixar.servidor.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfesorController {

	@Autowired
	ProfesorServiceImpl profeService;
	
	@Autowired
	DepartamentoServiceImpl depService;
	
	@Autowired
	AsignaturaServiceImpl asignService;
	
	@RequestMapping("/profesores")
	public String profesores(Model model) {
		
		model.addAttribute("profesores", profeService.getAllProfes());
		
		return "profesores/index";
	}
	
	@GetMapping("/profesores/asignaturas")
	public String profesoresAsign(@RequestParam(required = false, name = "error") String error,
			@RequestParam(required = false, name = "codigo") String codigo,
			Model model) {
		
		if (codigo == null || codigo == "") {
			
			model.addAttribute("error", "Profesor no seleccionado");
			
			return "redirect:/profesores/";
		}
		
		Profesor profeEntity = profeService.findProfesorById(Long.parseLong(codigo));
		
		
		model.addAttribute("asignatura", profeEntity);
		
		return "profesores/asignaturas";
	}
	
	@GetMapping("/profesores/addProfesor")
	public String addProfesorGradoGet(@RequestParam(required = false, name = "error") String error,
			@RequestParam(required = false, name = "profe") String nombre, 
			Model model) {
		
		ProfesorDTO profe = new ProfesorDTO();
		Departamento depart = new Departamento();
		
		model.addAttribute("depart", depService.getAllDepartments());
		model.addAttribute("profesor", profe);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		
		
		return "profesores/addProfesor";
	}
	
	@PostMapping("/profesores/addProfesor")
	public String addProfesorPost(@ModelAttribute ProfesorDTO profe, Model model) {
		
		Profesor profeDB = new Profesor();
		profeDB.setNombre(profe.getNombre());
		profeDB.setApellido1(profe.getApellido1());
		profeDB.setApellido2(profe.getApellido2());
		profeDB.setCiudad(profe.getCiudad());
		profeDB.setDireccion(profe.getDireccion());
		profeDB.setFechaNacimiento(profe.getFecha_nacimiento());
		profeDB.setNif(profe.getNif());
		profeDB.setSexo(profe.getSexo());
		
		Departamento departamentos = depService.findDepartamentoById(profe.getDepartamento());
		profeDB.setDepartamento(departamentos);
		
		if (profeService.insertarProfe(profeDB) == null) {
			
			return "redirect:/profesores/addProfesor?error=Existe&profesor=" + profe.getNombre();
		}
		
		return "redirect:/profesores";
	}
	
	@GetMapping("/profesores/addAsignatura")
	public String addAsignaturaGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="asignatura") String nombre,
			Model model) {
		
		AsignaturaDTO asignaturaDB = new AsignaturaDTO();
		
		List<Profesor> profesores = profeService.getAllProfes();
		List<Asignatura> asignaturas = asignService.getAllAsignaturas();
		
		model.addAttribute("profesores", profesores);
		model.addAttribute("asignaturas", asignaturas);
		
		model.addAttribute("asignatura", asignaturaDB);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		
		return "profesores/addAsignatura";
	}
	
	@PostMapping("/profesores/addAsignatura")
	public String addAsignaturaPost(
			@ModelAttribute AsignaturaDTO asignaturaDTO,
			Model model) {
		
		Profesor profesor = profeService.findProfesorById(asignaturaDTO.getProfesor());
		Optional<Asignatura> asignaturas = asignService.findAsigById(asignaturaDTO.getAsignatura());
		
		Asignatura asignatura = asignaturas.get();
		asignatura.setProfesor(profesor);
		
		if (asignService.actualizarAsignatura(asignatura) == null) {
			
			return "redirect:/profesores/addAsignatura?error=Existe&asignatura=" + asignaturaDTO.getAsignatura();
			
		}
		
		
		return "redirect:/profesores/asignaturas?codigo=" + asignaturaDTO.getProfesor();
		
	}
	
	
}
