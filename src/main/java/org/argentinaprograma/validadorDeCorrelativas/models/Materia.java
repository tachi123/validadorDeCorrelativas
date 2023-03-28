package org.argentinaprograma.validadorDeCorrelativas.models;

import java.util.ArrayList;
import java.util.List;

public class Materia {
	
	private String nombre;
	private List<Materia> correlativas;
	
	public Materia(String nombre) {
		this.setNombre(nombre);
		this.correlativas = new ArrayList<Materia>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(List<Materia> correlativas) {
		this.correlativas = correlativas;
	}
	
	public void agregarMateriaCorrelativa(Materia materia) {
		this.correlativas.add(materia);
	}
	
	public void quitarMateriaCorrelativa(Materia materia) {
		this.correlativas.remove(materia);
	}

	public boolean puedeCursar(Alumno alumno) {
		//Verificar que el alumno tenga las materias correlativas aprobadas
		if(this.getCorrelativas().size()==0) {
			return true;
		}else {
			for(Materia materia : this.getCorrelativas()) {
				if(!alumno.getMateriasAprobadas().contains(materia)) {
					return false;
				}		
			}
			return true;
		}
	}
	

}
