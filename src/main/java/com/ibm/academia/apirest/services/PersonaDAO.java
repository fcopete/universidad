package com.ibm.academia.apirest.services;

import java.util.Optional;

import com.ibm.academia.apirest.models.entities.Persona;

public interface PersonaDAO extends GenericoDAO<Persona>{
	
	
	public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
	public Optional<Persona> buscarPorDni(Integer dni);
	public Iterable<Persona> buscarPersonaPorApellido(String apellido);
	
}
