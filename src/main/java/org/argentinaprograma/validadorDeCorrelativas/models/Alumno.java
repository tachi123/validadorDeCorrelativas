package org.argentinaprograma.validadorDeCorrelativas.models;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

	private String nombre;
	private String legajo;
	private List<Materia> materiasAprobadas;
	
	public Alumno() {
		this.materiasAprobadas = new ArrayList<Materia>();
	}
	
	public Alumno(String nombre, String legajo) {
		this.setLegajo(legajo);
		this.setNombre(nombre);
		this.materiasAprobadas = new ArrayList<Materia>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	public List<Materia> getMateriasAprobadas() {
		return materiasAprobadas;
	}
	public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}
	
	public void agregarMateriaAprobada(Materia materia) {
		this.materiasAprobadas.add(materia);
	}
	
	public void quitarMateriaAprobada(Materia materia) {
		this.materiasAprobadas.remove(materia);
	}
	
		
}
