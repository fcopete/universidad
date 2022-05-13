package com.ibm.academia.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Direccion;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.services.AlumnoDAO;

@SpringBootApplication
public class UniversidadesRestApplication {

	/*@Autowired
	private AlumnoDAO alumnoDAO;*/
	public static void main(String[] args) {
		SpringApplication.run(UniversidadesRestApplication.class, args);
	}
	/*
		@Bean
		public CommandLineRunner runner() {
			
			return args->{
				Direccion direccion = new Direccion();
			 Persona alumno = new Alumno(null, "Mario", "Moreno", "126789", direccion);             
			Persona personaGuardar = alumnoDAO.guardar(alumno);
			System.out.println(personaGuardar.toString());
			};*/
			
		}
	


