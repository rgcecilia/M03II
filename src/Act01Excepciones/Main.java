package Act01Excepciones;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException, DemasiadosObjetos {

		System.out.println("Ejercicio 1 y Ejercicio 2");
		
		String nombreAlum1;
		String nombreAlum2;
		Integer edadAlum1;
		Integer edadAlum2;
		Double alturaAlum1;
		Double alturaAlum2;
		
		nombreAlum1 = Utils.pedirCadena("¿Nombre del alumno 1?");
		nombreAlum2 = Utils.pedirCadena("¿Nombre del alumno 2?");
		edadAlum1   = Utils.pedirEntero("¿Edad del alumno 1?");
		edadAlum2   = Utils.pedirEntero("¿Edad del alumno 2?");
		alturaAlum1 = Utils.pideDouble("¿Altura del alumno 1?");
		alturaAlum2 = Utils.pideDouble("¿Altura del alumno 2?");
		 
		System.out.println("Datos del Alumno 1: " + nombreAlum1 +" "+ edadAlum1 +" "+ alturaAlum1 +"\n" 
						 + "Datos del Alumno 2: " + nombreAlum2 +" "+ edadAlum2 +" "+ alturaAlum2 +"\n" 
						 + "Fin del Ejercicio 1 \n"
						 + "Ejercicio Numero 3 ");
		
		Alumnos misAlumnos = new Alumnos();
		
		misAlumnos.añadir("Juan",25);
		System.out.println(misAlumnos.toString());
		misAlumnos.añadir("Pepe",25);
		System.out.println(misAlumnos.toString());
		misAlumnos.añadir("Carlos",25);
		System.out.println(misAlumnos.toString());
		misAlumnos.añadir("Felipe",25);
		System.out.println(misAlumnos.toString());
		misAlumnos.añadir("Daniel",25);
		System.out.println(misAlumnos.toString());
		misAlumnos.añadir("Horse Luis",25);
	}

}
