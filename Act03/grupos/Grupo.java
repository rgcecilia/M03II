package grupos;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class Grupo {
	
	private String nombre;
	private String estilo;
	private int integrantes;
	
	public Grupo(String nombre, String estilo, int integrantes) {
		this.nombre = nombre;
		this.estilo = estilo;
		this.integrantes = integrantes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public int getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(int integrantes) {
		this.integrantes = integrantes;
	}
	
	@Override
	public String toString() {
		return "" + nombre + ", estilo: " + estilo + ", integrantes: " + integrantes + "";
	}

}
