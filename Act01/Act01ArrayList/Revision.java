package Act01ArrayList;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */

public class Revision extends Trabajo {
	
	private double extra = 20;
	
	public Revision(String descripcion, double precio, double horas, double material,boolean finalizado) {
		super(descripcion, precio, horas, material, finalizado);	
	}

	@Override
	public double getPrecio(){
		double total = (super.getHoras() * super.getFijo()) + extra;
		return total;
	}

}