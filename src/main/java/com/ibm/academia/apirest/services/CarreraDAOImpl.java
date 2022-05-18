package com.ibm.academia.apirest.services;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.repositories.CarreraRepository;

@Service
public class CarreraDAOImpl extends GenericoDAOImpl <Carrera, CarreraRepository> implements CarreraDAO
{

	@Autowired
	private CarreraRepository carreraRepository;
	
	@Autowired	
	public CarreraDAOImpl(CarreraRepository repository) {
		
		super(repository);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> findCarrerasByNombreContains(String nombre) {
	
	return repository.findCarrerasByNombreContains(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {
	
	return repository.findCarrerasByNombreContainsIgnoreCase(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios) {
	return repository.findCarrerasByCantidadAniosAfter(cantidadAnios);
	}

	@Override
	@Transactional
	public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido) {
		
		return carreraRepository.buscarCarrerasPorProfesorNombreYApellido(nombre, apellido);
	}
	
	@Override
	public Carrera actualizar(Carrera carreraEncontrada, Carrera carrera) {
	
	Carrera carreraActualizada = null;
	carreraEncontrada.setCantidadAnios(carrera.getCantidadAnios());
	carreraEncontrada.setCantidadMaterias(carrera.getCantidadMaterias());
	carreraActualizada = repository.save(carreraEncontrada);
	return carreraActualizada;
}
	
}
	

