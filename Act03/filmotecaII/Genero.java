package filmotecaII;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class Genero {
	
	private String genero;

	public Genero(String genero) {
		this.genero = genero;
	}
	
	public Genero() {
		this.genero = genero;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "" + genero + "";
	}
	
	

}
