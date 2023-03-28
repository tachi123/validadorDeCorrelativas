package org.argentinaprograma.validadorDeCorrelativas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.argentinaprograma.validadorDeCorrelativas.models.Alumno;
import org.argentinaprograma.validadorDeCorrelativas.models.Inscripcion;
import org.argentinaprograma.validadorDeCorrelativas.models.Materia;
import org.junit.Test;

public class InscripcionTest {

	//a. Una materia sin correlativas
	@Test
	public void validarInscripcionDeMateriaSinCorrelativas() {
		
		//Creamos materias
		Materia programacionI = new Materia("Programacion I");
		Materia programacionII = new Materia("Programacion II");
		Materia baseDeDatosI = new Materia("Base de datos I");
		
		//Agregamos una materia correlativa
		programacionII.agregarMateriaCorrelativa(programacionI);
		
		//Creamos un alumno
		Alumno alumno = new Alumno("Nahuel Ramirez","138000-0");
		
		//Creamos una inscripción SIN CORRELATIVAS
		Inscripcion inscripcion = new Inscripcion(alumno, baseDeDatosI);
		
		assertTrue(inscripcion.aprobada());
	}
	
	
	//b. Una materia con correlativas y que el alumno las tenga
	@Test
	public void validarInscripcionDeMateriaConCorrelativasYQueElAlumnoLasTenga() {
		
		//Creamos materias
		Materia programacionI = new Materia("Programacion I");
		Materia programacionII = new Materia("Programacion II");
		Materia baseDeDatosI = new Materia("Base de datos I");
		
		//Agregamos una materia correlativa
		programacionII.agregarMateriaCorrelativa(programacionI);
		
		//Creamos un alumno
		Alumno alumno = new Alumno("Nahuel Ramirez","138000-0");
		
		alumno.agregarMateriaAprobada(programacionI);

		//Creamos una inscripcion CON CORRELATIVAS APROBADAS
		Inscripcion inscripcion = new Inscripcion(alumno, programacionII);
		
		assertTrue(inscripcion.aprobada());
	}
	
	//c. Otra materia con correlativas, y que el alumno no las tenga
	@Test
	public void validarInscripcionDeMateriaConCorrelativasYQueElAlumnoNoLasTenga() {
		
		//Creamos materias
		Materia programacionI = new Materia("Programacion I");
		Materia programacionII = new Materia("Programacion II");
		Materia baseDeDatosI = new Materia("Base de datos I");
		
		//Agregamos una materia correlativa
		programacionII.agregarMateriaCorrelativa(programacionI);
		
		//Creamos un alumno
		Alumno alumno = new Alumno("Nahuel Ramirez","138000-0");

		//Creamos una inscripción SIN CORRELATIVAS
		Inscripcion inscripcion = new Inscripcion(alumno, programacionII);
		
		assertFalse(inscripcion.aprobada());
	}
		
	
	
}
