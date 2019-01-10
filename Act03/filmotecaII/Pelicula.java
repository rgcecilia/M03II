
package filmotecaII;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M0
 */
public class Pelicula {

		private int id;
		private String titulo;
		private int director;
		private String pais;
		private String duracion;
		private String genero;
		
		public Pelicula() {
		}
		
		public Pelicula(String titulo, int director, String pais, String duracion, String genero) {
			super();
			this.titulo = titulo;
			this.director = director;
			this.pais = pais;
			this.duracion = duracion;
			this.genero = genero;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public int getDirector() {
			return director;
		}
		public void setDirector(int director) {
			this.director = director;
		}
		public String getPais() {
			return pais;
		}
		public void setPais(String pais) {
			this.pais = pais;
		}
		public String getDuracion() {
			return duracion;
		}
		public void setDuracion(String duracion) {
			this.duracion = duracion;
		}
		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}
		@Override
		public String toString() {
			return "" + titulo + "";
		}

	
}
