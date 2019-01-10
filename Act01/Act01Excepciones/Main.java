package Act01Excepciones;

import java.io.IOException;


/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */

public class Main {

	public static void main(String[] args) throws IOException, DemasiadosObjetos {

		System.out.println("Ejercicio 1 y Ejercicio 2");
		
		String nombreAlum1;
		String nombreAlum2;
		Integer edadAlum1;
		Integer edadAlum2;
		Double alturaAlum1;
		Double alturaAlum2;
		
		/*En las funciones controlamos los valores de entrada clase Utils*/
		nombreAlum1 = Utils.pedirCadena("¿Nombre del alumno 1?");
		nombreAlum2 = Utils.pedirCadena("¿Nombre del alumno 2?");
		edadAlum1   = Utils.pedirEntero("¿Edad del alumno 1?");
		edadAlum2   = Utils.pedirEntero("¿Edad del alumno 2?");
		alturaAlum1 = Utils.pideDouble("¿Altura del alumno 1?");
		alturaAlum2 = Utils.pideDouble("¿Altura del alumno 2?");
		 
		/*En las funciones controlamos los valores de entrada clase Utils*/
		System.out.println("Datos del Alumno 1: " + nombreAlum1 +" "+ edadAlum1 +" "+ alturaAlum1 +"\n" 
						 + "Datos del Alumno 2: " + nombreAlum2 +" "+ edadAlum2 +" "+ alturaAlum2 +"\n" 
						 + "Fin del Ejercicio 1 y 2 \n"
						 + "Ejercicio Numero 3 ");
		
		/*Creamos el nuevo array, y en su constructor limitamos el tamaño a 5*/	
		Alumnos misAlumnos = new Alumnos();
		
		/*Creamos el nuevo array, y en su constructor limitamos el tamaño a 5*/
		misAlumnos.añadir("Juan",25);
		misAlumnos.añadir("Pepe",25);
		misAlumnos.añadir("Carlos",25);
		misAlumnos.añadir("Felipe",25);
		misAlumnos.añadir("Daniel",25);
		System.out.println(misAlumnos.toString());
		
		/*Si intentamos añadir un sexto alumno a nuestro array...
		 * El programa lanza nuestra excepcion de tipo demasiados objetos*/
		System.out.println("Intentamos añadir un 6 objeto al array...");
		misAlumnos.añadir("Francisco",25);
	}

}
