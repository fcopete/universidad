package com.ibm.academia.apirest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "pabellones", schema = "universidad")
public class Pabellon implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Positive(message = "Debe de ser mayo a 0")
	@Column(name = "metros_cuadrados")
	private Double tamanioMetros;
	
	@NotNull(message = "No puede ser vacio")
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 5, max = 80)
	@Column(name = "nombre", unique = true, nullable = false)
	private String nombre;
	
	@Column(name = "fecha_Alta")
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
		@AttributeOverride(name = "departamento", column = @Column(name = "departamento")),
	})
	private Direccion direccion;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "pabellon"})
	@OneToMany(mappedBy = "pabellon", fetch = FetchType.LAZY)
	private Set<Aula> aulas;
		
	public Pabellon(Integer id, Double tamanioMetros, String nombre, Direccion direccion) {
		this.id = id;
		this.tamanioMetros = tamanioMetros;
		this.nombre = nombre;
		this.direccion = direccion;
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
		Pabellon other = (Pabellon) obj;
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

	private static final long serialVersionUID = 5895151497921997034L;

}
