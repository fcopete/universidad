package com.ibm.academia.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.services.CarreraDAO;

@Component
public class Comandos implements CommandLineRunner
{

	@Autowired
	private CarreraDAO carreraDAO;
	
	@Override
	public void run(String... args) throws Exception {
		/*Carrera finanzas = new Carrera(null,"Ingenieria en Finanzas",20,3);
		Carrera carreraGuardar = carreraDAO.guardar(finanzas);
		System.out.println(carreraGuardar.toString());*/
		
	}

}
