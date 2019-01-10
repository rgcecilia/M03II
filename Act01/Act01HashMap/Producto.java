package Act01HashMap;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */

public class Producto {

		private String nombre;
		private int precio;
		
		public Producto (String nombre, int precio) {
			this.nombre = nombre;
			this.precio = precio;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}
		
		
	    @Override
	    public String toString() {
	        return  "Nombre = " + this.getNombre() + " Precio = " + this.getPrecio();
	    }
	    
		@Override
	    public int hashCode(){
	    	int hash = this.precio + this.nombre.hashCode();
	        return hash;
	    } 
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Producto other = (Producto) obj;
			if (nombre == null) {
				if (other.nombre != null)
					return false;
			} else if (!nombre.equals(other.nombre))
				return false;
			if (precio != other.precio)
				return false;
			return true;
		}


}
