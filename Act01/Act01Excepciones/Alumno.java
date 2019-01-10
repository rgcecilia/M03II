package Act01Excepciones;
/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */

public class Alumno {

		private String nombre;
		private Integer edad;
				
		public Alumno(String nombre, Integer edad) {
			this.nombre = nombre;
			this.edad = edad;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Integer getEdad() {
			return edad;
		}
		public void setEdad(Integer edad) {
			this.edad = edad;
		}
		@Override
		public String toString() {
			return "Alumno [nombre=" + nombre + ", edad=" + edad + "]";
		}
		
}
