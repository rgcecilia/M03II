package Act01ArrayList;

public class Revision extends Trabajo {
	
	private double extra = 20;
	
	/* Funcion para calcular el precio del trabajo
	 * @see actividad08.Vehiculo#getAlquiler(int)
	 */
	
	public Revision(String descripcion, double precio, double horas, double material,boolean finalizado) {
		super(descripcion, precio, horas, material, finalizado);	
	}

	@Override
	public double getPrecio(){
		double total = (super.getHoras() * super.getFijo()) + extra;
		return total;
	}

}