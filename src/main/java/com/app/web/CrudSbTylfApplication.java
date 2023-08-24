package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entidad.Estudiante;
import com.app.web.repository.EstudianteRepository;

@SpringBootApplication
public class CrudSbTylfApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudSbTylfApplication.class, args);
	}

	@Autowired
	private EstudianteRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		Estudinate e1 = new Estudinate("Edgar", "Jasso", "untaljasso@gmail.com");
		repo.save(e1);
		Estudinate e2 = new Estudinate("Edgardo", "Jasson", "untaljasso97@gmail.com");
		repo.save(e2);
		*/
	}

}
