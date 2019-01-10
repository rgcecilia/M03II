package Act01HashMap;

import java.util.HashMap;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */

public class Tienda {
	
	private HashMap<Producto, Integer> stock;
	
	public Tienda() {
		stock = new HashMap<>();
	}
	
	/**Funcion para Añadir Productos al HashMap
	 * @param nombre del producto, precio del producto y stock
	 */
	public void añadir (String nombre, int precio, int stock) {
		Producto nuevo = new Producto(nombre, precio);	
		if(!this.stock.containsKey(nuevo)){
			this.stock.put(nuevo, stock);	
		} else {
			System.out.println("Ya existe un producto con esa clave");
		}
	}
	
	/**Funcion para modificar un producto del hash map
	 * @param nombre del producto, precio del producto y stock
	 */
	public void modificar (String nombre, int precio, int stock) {
		this.stock.put(new Producto(nombre, precio), stock);	
	}
	
	/**Funcion para borrar un producto del hash map
	 * @param nombre del producto, precio del producto
	 */
	public void borrar (String nombre, int precio) {
		this.stock.remove(new Producto(nombre, precio));	
	}
	
	/**Funcion para borrar un producto del hash map
	 */
	public void resetear () {
		this.stock.clear();
	}

	@Override
	public String toString() {
		return "Tienda [stock=" + stock + "]";
	}

	
}
