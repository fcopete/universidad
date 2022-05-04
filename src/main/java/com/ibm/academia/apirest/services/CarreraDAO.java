package com.ibm.academia.apirest.services;
import com.ibm.academia.apirest.entities.Carrera;
import java.util.Optional;

public interface CarreraDAO {
	
	public Optional <Carrera> buscarPorId(Integer ID);
	public Carrera guardar (Carrera carrera);
	public Iterable <Carrera> buscarTodos();
	public void eliminarPorId(Integer id);
	

}
