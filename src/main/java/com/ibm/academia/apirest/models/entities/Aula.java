package com.ibm.academia.apirest.models.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.academia.apirest.enums.Pizarron;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table (name= "aulas", schema = "universidad")
public class  Aula implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="numero_aula", nullable = false)
	private Integer numeroAula;
	
	@Column(name="medidas")
	private String medidas;
	
	@Column(name="cantidad_pupitres")
	private Integer cantidadPupitres;
	
	@Column(name = "tipo_pizarron")
	@Enumerated(EnumType.STRING)
	private Pizarron pizarron;
	
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "aulas"})
	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "pabellon_id", foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
	private Pabellon pabellon;
	
	public Aula(Integer id, Integer numeroAula, String medidas, Integer cantidadPupitres, Pizarron pizarron) {
		super();
		this.id = id;
		this.numeroAula = numeroAula;
		this.medidas = medidas;
		this.cantidadPupitres = cantidadPupitres;
		this.pizarron = pizarron;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id, numeroAula);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(id, other.id) && Objects.equals(numeroAula, other.numeroAula);
	}

	@PrePersist
	private void antesPersistir() {
		this.fechaCreacion = new Date(); 
	}
	
	@PreUpdate
	private void antesActualizar() {
		this.fechaModificacion = new Date(); 
	}

	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNumeroAula() {
		return numeroAula;
	}


	public void setNumeroAula(Integer numeroAula) {
		this.numeroAula = numeroAula;
	}


	public String getMedidas() {
		return medidas;
	}


	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}


	public Integer getCantidadPupitres() {
		return cantidadPupitres;
	}


	public void setCantidadPupitres(Integer cantidadPupitres) {
		this.cantidadPupitres = cantidadPupitres;
	}


	public Pizarron getPizarron() {
		return pizarron;
	}


	public void setPizarron(Pizarron pizarron) {
		this.pizarron = pizarron;
	}


	public Pabellon getPabellon() {
		return pabellon;
	}


	public void setPabellon(Pabellon pabellon) {
		this.pabellon = pabellon;
	}



	private static final long serialVersionUID = 5917610003959988369L;

}
