package com.app.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Estudiante;
import com.app.web.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	private EstudianteRepository repo;
	
	@Override
	public List<Estudiante> listarEstudiantes() {
		return repo.findAll();
	}

	@Override
	public Estudiante guardarEstudiante(Estudiante e) {
		return repo.save(e);
	}

	@Override
	public Estudiante obtenerEstudianteById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante e) {
		return repo.save(e);
	}

	@Override
	public void eliminarEstudiante(Long id) {
		repo.deleteById(id);
	}

}
