package com.ibm.academia.apirest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "personas", schema = "universidad")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Persona implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "dni", unique = true)
	private String dni;
	
	@Column(name = "fecha_alta")
	private Date fechaCreacion;
	
	@Column(name = "fecha_actualizacion")
	private Date fechaModificacion;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
		@AttributeOverride(name = "departamento", column = @Column(name = "departamento")),
	})
	
	private Direccion direccion;
	
	public Persona(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(id, other.id);
	}

	@PrePersist
	private void antesPersistir() {
		this.fechaCreacion = new Date(); 
	}
	
	@PreUpdate
	private void antesActualizar() {
		this.fechaModificacion = new Date(); 
	}
	
	private static final long serialVersionUID = 7435045832876635940L;
	

}
