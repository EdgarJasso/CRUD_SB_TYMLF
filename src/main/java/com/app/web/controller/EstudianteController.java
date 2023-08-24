package com.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Estudiante;
import com.app.web.service.EstudianteService;

@Controller
public class EstudianteController {

	@Autowired
	private EstudianteService service;

	@GetMapping({ "/estudiantes", "/" })
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantesLista", service.listarEstudiantes());
		return "estudiantes";
	}

	@GetMapping("/estudiantes/nuevo")
	public String estudianteNuevoForm(Model modelo) {
		Estudiante estudiante = new Estudiante();
		modelo.addAttribute("estudiante", estudiante);
		return "crear_estudiante";
	}

	@PostMapping("/estudianteSave")
	public String estudianteSave(@ModelAttribute("estudiante") Estudiante estudiante) {
		service.guardarEstudiante(estudiante);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/editar/{id}")
	public String estudianteEditarForm(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("estudiante", service.obtenerEstudianteById(id));
		return "editar_estudiante";
	}

	@PostMapping("/estudiantes/{id}")
	public String estudianteUpdate(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante,
			Model modelo) {
		Estudiante estudianteEncontrado = service.obtenerEstudianteById(id);
		estudianteEncontrado.setId(id);
		estudianteEncontrado.setNombre(estudiante.getNombre());
		estudianteEncontrado.setApellido(estudiante.getApellido());
		estudianteEncontrado.setEmail(estudiante.getEmail());
		service.actualizarEstudiante(estudianteEncontrado);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/eliminar/{id}")
	public String estudianteEliminar(@PathVariable Long id) {
		service.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}
}
