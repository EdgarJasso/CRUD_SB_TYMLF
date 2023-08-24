package com.app.web.service;

import java.util.List;

import com.app.web.entidad.Estudiante;

public interface EstudianteService {

	public List<Estudiante> listarEstudiantes();
	public Estudiante guardarEstudiante(Estudiante e);
	public Estudiante obtenerEstudianteById(Long id);
	public Estudiante actualizarEstudiante(Estudiante e);
	public void eliminarEstudiante(Long id);
	
}
