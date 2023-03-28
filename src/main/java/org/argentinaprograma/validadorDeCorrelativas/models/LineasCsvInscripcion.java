package org.argentinaprograma.validadorDeCorrelativas.models;

import com.opencsv.bean.CsvBindByPosition;

public class LineasCsvInscripcion {

	@CsvBindByPosition(position=0)
	private String nombreAlumno;
	
	@CsvBindByPosition(position=1)
	private String nombreMateria;

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	
	
}
