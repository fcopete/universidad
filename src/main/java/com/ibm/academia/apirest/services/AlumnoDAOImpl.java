package com.ibm.academia.apirest.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.repositories.PersonaRepository;

@Service
public class AlumnoDAOImpl extends PersonaDAOImpl  implements AlumnoDAO {
	
	@Autowired
	public AlumnoDAOImpl(@Qualifier("repositorioAlumnos")PersonaRepository repository) {
		super(repository);
		
	}

	@Override
	@Transactional
	public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre) {
		
		return ((AlumnoDAO)repository).buscarAlumnoPorNombreCarrera(nombre);
	}



	@Override
	@Transactional
	public Persona actualizar(Persona alumnoEncontrado, Persona alumno) {
		Persona alumnoActualizado = null;
		alumnoEncontrado.setNombre(alumno.getNombre());
		alumnoEncontrado.setApellido(alumno.getApellido());
		alumnoEncontrado.setDireccion(alumno.getDireccion());
		alumnoActualizado = repository.save(alumnoEncontrado);
		return alumnoActualizado;
	}

	@Override
	@Transactional
	public Persona asociarCarreraAlumno(Persona alumno, Carrera carrera) {
		
		((Alumno)alumno).setCarrera(carrera);
		return repository.save(alumno);
	}
	
	

		
}
