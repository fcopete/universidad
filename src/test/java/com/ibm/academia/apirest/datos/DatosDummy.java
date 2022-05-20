package com.ibm.academia.apirest.datos;

import java.math.BigDecimal;

import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.models.entities.Alumno;
import com.ibm.academia.apirest.models.entities.Aula;
import com.ibm.academia.apirest.models.entities.Carrera;
import com.ibm.academia.apirest.models.entities.Direccion;
import com.ibm.academia.apirest.models.entities.Empleado;
import com.ibm.academia.apirest.models.entities.Pabellon;
import com.ibm.academia.apirest.models.entities.Persona;
import com.ibm.academia.apirest.models.entities.Profesor;

public class DatosDummy {

	public static Carrera carrera01() {
		return new Carrera(null, "Ingenieria en Sistemas", 40, 4);
	}

	public static Carrera carrera02() {
		return new Carrera(null, "Licenciatura en Contaduria", 38, 4);
	}

	public static Carrera carrera03() {
		return new Carrera(null, "Ingenieria Aeronautica", 50, 5);
	}

	public static Persona empleado01() {

		return new Empleado(null, "Juan", "Hernandez", "456985", new Direccion(), new BigDecimal("6983"),
				TipoEmpleado.ADMINISTRATIVO);
	}

	public static Persona empleado02() {

		return new Empleado(null, "Alejandro", "Lopez", "44589", new Direccion(), new BigDecimal("9685"),
				TipoEmpleado.ADMINISTRATIVO);
	}

	public static Persona empleado03() {

		return new Empleado(null, "Daniel", "Cabrera", "66983", new Direccion(), new BigDecimal("3368"),
				TipoEmpleado.MANTENIMIENTO);
	}

	public static Persona alumno01() {

		return new Alumno(null, "Angelica", "MArtinez", "33698", new Direccion());
	}

	public static Persona alumno02() {

		return new Alumno(null, "Ricardo", "Vargas", "369741", new Direccion());
	}

	public static Persona alumno03() {

		return new Alumno(null, "Raul", "Gutierrez", "69854", new Direccion());
	}

	public static Persona profesor01() {

		return new Profesor(null, "Beatriz", "Castillo", "99658", new Direccion(), new BigDecimal("66985"));
	}

	public static Persona profesor02() {

		return new Profesor(null, "Laura", "Leon", "66654", new Direccion(), new BigDecimal("66657"));

	}

	public static Persona profesor03() {

		return new Profesor(null, "Ximena", "Lara", "44156", new Direccion(), new BigDecimal("665210"));
	}

	public static Aula aula01() {

		return new Aula(null, 1, "60.55", 22, Pizarron.PIZARRA_BLANCA);
	}

	public static Aula aula02() {

		return new Aula(null, 1, "120.0", 15, Pizarron.PIZARRA_BLANCA);
	}

	public static Aula aula03() {

		return new Aula(null, 3, "240.96", 80, Pizarron.PIZARRA_TIZA);
	}
	
	public static Pabellon pabellon01() {
		
		return new Pabellon(null, 205.30,"Contabilidad", new Direccion());
		
	}
	
public static Pabellon pabellon02() {
		
		return new Pabellon(null, 100.01,"Direccion", new Direccion());
		
	}

public static Pabellon pabellon03() {
	
	return new Pabellon(null, 110.52,"Juridico", new Direccion());
	
}

}
