package com.ibm.academia.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.services.AlumnoDAO;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.PersonaDAO;
import com.ibm.academia.apirest.services.ProfesorDAO;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
	
	@Autowired
	@Qualifier("profesorDAOImpl")
	private PersonaDAO profesorDAO;
	
	@Autowired
	private CarreraDAO carreraDAO;
	
		
	@PostMapping
	  public ResponseEntity<?> crearProfesor(@RequestBody Persona profesor){
	    
	    Persona profesorGuardado = profesorDAO.guardar(profesor);
	    return new ResponseEntity<Persona>(profesorGuardado, HttpStatus.CREATED);
	  }
	
	@GetMapping("/profesor/lista")
	  public ResponseEntity<?> obtenerTodos() {
	    
	    List<Persona> profesores = (List<Persona>) profesorDAO.buscarTodos();
	    
	    if(profesores.isEmpty())
	      throw new NotFoundException("No existen profesores");
	    return new ResponseEntity<List<Persona>>(profesores, HttpStatus.OK);
	  }
	
	
	@GetMapping("/profesorId/{profesorId}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer profesorId)
    {
        Optional<Persona> oProfesor = profesorDAO.buscarPorId(profesorId);
        
        if(!oProfesor.isPresent()) 
            throw new NotFoundException(String.format("Alumno con id %d no existe", profesorId));
        
        return new ResponseEntity<Persona>(oProfesor.get(), HttpStatus.OK);
    }
	
	
	  @PutMapping("/upd/profesorId/{profesorId}")
	  public ResponseEntity<?> actualizarProfesor(@PathVariable Integer profesorId, @RequestBody Persona profesor) {
	    Optional<Persona> oProfesor = profesorDAO.buscarPorId(profesorId);
	    
	    if(!oProfesor.isPresent())
	      throw new NotFoundException(String.format("El alumno con ID %d no existe", profesorId));
	    
	    Persona profesorActualizado = ((ProfesorDAO)profesorDAO).actualizar(oProfesor.get(), profesor);
	    return new ResponseEntity<Persona>(profesorActualizado, HttpStatus.OK);
	  }
	  
	  /*
	  @DeleteMapping("/profesorId/{profesorId}")
	  public ResponseEntity<?> eliminarProfesor(@PathVariable Integer profesorId){
	    Optional<Persona> oProfesor = profesorDAO.buscarPorId(profesorId);
	    
	    if(!oProfesor.isPresent())
	      throw new NotFoundException(String.format("El alumno con ID %d no existe", profesorId));
	    
	    profesorDAO.eliminarPorId(oProfesor.get().getId()); 
	    
	    return new ResponseEntity<String>("Profesor ID: " + profesorId + " se elimino satisfactoriamente",  HttpStatus.NO_CONTENT);
	  }*/
	  
	  @PutMapping("/profesorId/{profesorId}/carrera/{carreraId}")
	  public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer carreraId, @PathVariable Integer profesorId) {
	    Optional<Persona> oProfesor = profesorDAO.buscarPorId(profesorId);
	        if(!oProfesor.isPresent()) 
	            throw new NotFoundException(String.format("Profesor con id %d no existe", profesorId));
	        
	        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);
	        if(!oCarrera.isPresent())
	            throw new NotFoundException(String.format("Carrera con id %d no existe", carreraId));
	        
	        Persona profesor = ((ProfesorDAO)profesorDAO).asociarCarreraProfesor(oProfesor.get(), oCarrera.get());
	        
	        return new ResponseEntity<Persona>(profesor, HttpStatus.OK);
	  }

}
