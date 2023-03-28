package org.argentinaprograma.validadorDeCorrelativas.servicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.argentinaprograma.validadorDeCorrelativas.excepciones.NoExisteAlumnoExcepcion;
import org.argentinaprograma.validadorDeCorrelativas.excepciones.NoExisteMateriaExcepcion;
import org.argentinaprograma.validadorDeCorrelativas.models.Alumno;
import org.argentinaprograma.validadorDeCorrelativas.models.Inscripcion;
import org.argentinaprograma.validadorDeCorrelativas.models.LineasCsvInscripcion;
import org.argentinaprograma.validadorDeCorrelativas.models.Materia;

import com.opencsv.bean.CsvToBeanBuilder;

public class LectorCSV {

	public String rutaArchivo;
	public List<LineasCsvInscripcion> lineasArchivo;
	
	public LectorCSV(String ruta) {
		this.rutaArchivo = ruta;
		this.leerElArchivo();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void leerElArchivo() {
		
		List<LineasCsvInscripcion> lineasLeidas = null;
		
		try {
			//Agrego el encoding del archivo en FileReader
			lineasLeidas = new CsvToBeanBuilder(new FileReader(this.rutaArchivo, StandardCharsets.UTF_8))
					// con esta configuracion salteamos el encabezado
					.withSkipLines(1)
					// tenemos que declarar el tipo de dato que va a generar con cada linea del csv
					.withType(LineasCsvInscripcion.class)
					.build().parse();
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.lineasArchivo = lineasLeidas;
	}
	
	public void listarInscripciones(List<Alumno> alumnos, List<Materia> materias){
		//POR CADA LINEA DEL CSV LEIDO TENGO QUE CREAR LA INSCRIPCION
		//PARA CREAR LA INSCRIPCION DEBO BUSCAR EL ALUMNO POR EL NOMBRE
		// Y BUSCAR LA MATERIA POR EL NOMBRE
		List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
		
		for(LineasCsvInscripcion lineaLeida : this.lineasArchivo) {
			
			try {
				Inscripcion inscripcion = this.validarInscripciono(alumnos, materias, lineaLeida);
				this.imprimirEnPantalla(lineaLeida.getNombreAlumno(), lineaLeida.getNombreMateria(), inscripcion.aprobadaString());
			} catch (NoExisteAlumnoExcepcion e) {
				this.imprimirEnPantalla(lineaLeida.getNombreAlumno(), lineaLeida.getNombreMateria(), "No existe el/la alumno/a");
			} catch (NoExisteMateriaExcepcion e) {
				this.imprimirEnPantalla(lineaLeida.getNombreAlumno(), lineaLeida.getNombreMateria(), "No existe la materia");
			}

		}
	}
	
	public Inscripcion validarInscripciono(List<Alumno> alumnos, List<Materia> materias, LineasCsvInscripcion lineaLeida) throws NoExisteAlumnoExcepcion, NoExisteMateriaExcepcion {
		//busqueda del alumno por el nombre de la linea del csv
		Alumno alumnoLeido = null;
		for(Alumno alumnoDeLaLista : alumnos) {
			if(alumnoDeLaLista.getNombre().equalsIgnoreCase(lineaLeida.getNombreAlumno())) {
				alumnoLeido = alumnoDeLaLista;
			}
		}		
		//busqueda de la materia por el nombre de la linea del csv
		Materia materiaLeida = null;
		for(Materia materiaDeLaLista : materias) {
			if(materiaDeLaLista.getNombre().equalsIgnoreCase(lineaLeida.getNombreMateria())){
				materiaLeida = materiaDeLaLista;
			}
		}
		
		//Agregar validacion de que la materia y el alumno exista
		if(alumnoLeido == null) {
			throw new NoExisteAlumnoExcepcion();
		}
		if(materiaLeida == null) {
			throw new NoExisteMateriaExcepcion();
		}
		
		return new Inscripcion(alumnoLeido,materiaLeida);
	}
	
	public void imprimirEnPantalla(String nombreAlumno, String nombreMateria, String resultado) {
		// Se usa el % para formatear. Se indica con -20 la cantidad de espacios de texto de separacion
		System.out.printf("%-20s%-20s%-20s\n",nombreAlumno,nombreMateria,resultado);
	}
	
}
