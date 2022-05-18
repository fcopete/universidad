package com.ibm.academia.apirest.models.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO {
	
	
	private Integer id;
	
	@NotNull(message = "No puede ser vacio")
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 5, max = 80)
	private String nombre;
	
	@Positive(message = "Debe de ser mayor a 0")
	private Integer cantidadAnios;
	
	@Positive(message = "Debe de ser mayor a 0")
	private Integer cantidadMaterias;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidadAnios() {
		return cantidadAnios;
	}

	public void setCantidadAnios(Integer cantidadAnios) {
		this.cantidadAnios = cantidadAnios;
	}

	public Integer getCantidadMaterias() {
		return cantidadMaterias;
	}

	public void setCantidadMaterias(Integer cantidadMaterias) {
		this.cantidadMaterias = cantidadMaterias;
	}
	
	
	
}