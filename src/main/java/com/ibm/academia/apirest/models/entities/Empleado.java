package com.ibm.academia.apirest.models.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.ForeignKey;
import javax.persistence.Table;

import com.ibm.academia.apirest.enums.TipoEmpleado;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "empleados", schema = "universidad")
@PrimaryKeyJoinColumn(name = "persona_id")

public class Empleado extends Persona 
{
	@Column(name = "sueldo")
	private BigDecimal sueldo;
	
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "pabellon_id", foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
	private Pabellon pabellon;
	
	@Column(name = "tipo_empleado")
	@Enumerated(EnumType.STRING)
	private TipoEmpleado tipoEmpleado;

	public Empleado(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo, TipoEmpleado tipoEmpleado) {
		super(id, nombre, apellido, dni, direccion);
		this.sueldo = sueldo;
		this.tipoEmpleado= tipoEmpleado;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\tEmpleado [sueldo=" + sueldo + ", tipoEmpleado=" + tipoEmpleado + "]";
	}
	
	
	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	public Pabellon getPabellon() {
		return pabellon;
	}

	public void setPabellon(Pabellon pabellon) {
		this.pabellon = pabellon;
	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}


	private static final long serialVersionUID = -6140365300357910257L;
	
	
	

	
}