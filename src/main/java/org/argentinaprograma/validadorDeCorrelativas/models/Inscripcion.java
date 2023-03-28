package org.argentinaprograma.validadorDeCorrelativas.models;

import java.time.LocalDate;

public class Inscripcion {

	private Alumno alumno;
	private Materia materia;
	private LocalDate fecha;
	
	public Inscripcion(Alumno alumno, Materia materia) {
		this.setAlumno(alumno);
		this.setMateria(materia);
		this.setFecha(LocalDate.now());
	}
	
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean aprobada() {
		return this.materia.puedeCursar(this.alumno);
	}
	
	//Devuelvo aprobado o rechazado
	public String aprobadaString() {
		if(this.aprobada()) {
			return "Aprobada";
		}else {
			return "Rechazada";
		}
	}
}
