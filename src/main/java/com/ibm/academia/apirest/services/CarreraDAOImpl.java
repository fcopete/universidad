package com.ibm.academia.apirest.services;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.entities.Carrera;

@Service
public class CarreraDAOImpl implements CarreraDAO
{

	@Autowired
	private com.ibm.academia.apirest.repositories.CarreraRepository CarreraRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Carrera> buscarPorId(Integer id) {
		return CarreraRepository.findById(id);
	}

	@Override
	@Transactional
	public Carrera guardar(Carrera carrera) {
		return CarreraRepository.save(carrera);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> buscarTodos() {
		return CarreraRepository.findAll();
	}

	@Override
	@Transactional
	public void eliminarPorId(Integer id) {
				
	}

}
