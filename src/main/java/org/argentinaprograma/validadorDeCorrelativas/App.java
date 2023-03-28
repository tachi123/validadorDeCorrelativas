package org.argentinaprograma.validadorDeCorrelativas;

import java.util.ArrayList;
import java.util.List;

import org.argentinaprograma.validadorDeCorrelativas.models.Alumno;
import org.argentinaprograma.validadorDeCorrelativas.models.LineasCsvInscripcion;
import org.argentinaprograma.validadorDeCorrelativas.models.Materia;
import org.argentinaprograma.validadorDeCorrelativas.servicios.LectorCSV;

public class App 
{
	public static void main(String[] args) {
		// Inicializar materias: crear 3 o 4 materias, con y sin correlativas
		//Creamos materias
		Materia programacionI = new Materia("Programación I");
		Materia programacionII = new Materia("Programación II");
		Materia baseDeDatosI = new Materia("Base de datos I");
		
		//Agregamos una materia correlativa
		programacionII.agregarMateriaCorrelativa(programacionI);
		
		List<Materia> materias = new ArrayList<Materia>();
		materias.add(programacionI);
		materias.add(programacionII);
		materias.add(baseDeDatosI);
		
		// Inicializar los alumnos, crear 2 o 3 alumnos, con y sin materias aprobadas.
		//Creo un alumno con una materia aprobada
		Alumno alumno1 = new Alumno("Vanesa Sosa","138000-0");
		//alumno1.agregarMateriaAprobada(programacionI);

		Alumno alumno2 = new Alumno("José Rodríguez","150000-0");
				
		// Usar para las materias los MISMOS objetos de la colección de más arriba
		List<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos.add(alumno1);
		alumnos.add(alumno2);
				
		// Leer el archivo parado por parámetros de args y por cada línea
		
		LectorCSV archivoLeido = new LectorCSV("src/main/resources/inscripcion.csv");
		
		//Validar inscripciones
		archivoLeido.listarInscripciones(alumnos, materias);
				
	}
}
