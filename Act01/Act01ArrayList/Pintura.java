package Act01ArrayList;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */

public class Pintura extends Trabajo {
	
	private double suplementoPintura = 1.3;
	
	/* Funcion para calcular el precio del trabajo
	 * @see actividad08.Vehiculo#getAlquiler(int)
	 */
	
	public Pintura(String descripcion, double precio, double horas, double material,boolean finalizado) {
		super(descripcion, precio, horas, material, finalizado);	
	}

	@Override
	public double getPrecio(){
		double total = (super.getHoras() * super.getFijo()  
				+ (suplementoPintura * super.getMaterial()));
		return total;
	}

}