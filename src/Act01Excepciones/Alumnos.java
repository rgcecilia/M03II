package Act01Excepciones;

import java.util.ArrayList;

public class Alumnos {
	
	
	private ArrayList<Alumno> misAlumnos;
	
	public Alumnos() {
		super();
		this.misAlumnos = new ArrayList<>();
	}

	public void añadir (String nombre, int edad) throws DemasiadosObjetos{
		if (misAlumnos.size() == 5) {
		 throw new DemasiadosObjetos("117") ;
		} else {
			Alumno nuevo = new Alumno(nombre, edad);
			misAlumnos.add(nuevo);
		}
	}

	@Override
	public String toString() {
		return "Alumnos [misAlumnos =" + misAlumnos + "]";
	}
	
	
}
