package com.ibm.academia.apirest.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "carreras", schema = "universidad")

public class Carrera implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "No puede ser vacio")
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 5, max = 80)
	@Column(name = "nombre", unique = true)
	private String nombre;
	
	@Positive(message = "Debe de ser mayor a 0")
	@Column(name = "cantidad_materias")
	private Integer cantidadMaterias;
	
	@Positive(message = "Debe de ser mayor a 0")
	@Column(name = "cantidad_anios")
	private Integer cantidadAnios;
	
	@Column(name = "fecha_alta")
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	
	
	@ManyToMany(mappedBy = "carreras", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"carreras"})
	private Set<Profesor> profesores;
	
	@OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"carrera"})
	private Set<Alumno> alumnos;
	
	public Carrera (Integer id, String nombre, Integer cantidadMaterias, Integer cantidadAnios)
	{
		this.id = id;
		this.nombre = nombre;
		this.cantidadMaterias = cantidadMaterias;
		this.cantidadAnios = cantidadAnios;
	}
	
	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + ", cantidadMaterias=" + cantidadMaterias
				+ ", cantidadAnios=" + cantidadAnios + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion="
				+ fechaModificacion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrera other = (Carrera) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	@PrePersist
	private void antesPersistir() {
		this.fechaCreacion = new Date(); 
	}
	
	@PreUpdate
	private void antesActualizar() {
		this.fechaModificacion = new Date(); 
	}
	
	
	
	public Integer getCantidadMaterias() {
		return cantidadMaterias;
	}

	public void setCantidadMaterias(Integer cantidadMaterias) {
		this.cantidadMaterias = cantidadMaterias;
	}

	public Integer getCantidadAnios() {
		return cantidadAnios;
	}

	public void setCantidadAnios(Integer cantidadAnios) {
		this.cantidadAnios = cantidadAnios;
	}

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




	private static final long serialVersionUID = 7386711690996525949L;

}
