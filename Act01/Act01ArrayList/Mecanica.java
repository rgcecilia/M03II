package Act01ArrayList;

public class Mecanica extends Trabajo {
	
	private double suplementoMecanica = 1.1;
	
	/* Funcion para calcular el precio del trabajo
	 * @see actividad08.Vehiculo#getAlquiler(int)
	 */
	
	public Mecanica(String descripcion, double precio, double horas, double material,boolean finalizado) {
		super(descripcion, precio, horas, material, finalizado);	
	}

	@Override
	public double getPrecio(){
		double total = (super.getHoras() * super.getFijo()  
				+ (suplementoMecanica * super.getMaterial()));
		return total;
	}

}
