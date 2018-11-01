package Act01HashMap;

import java.util.HashMap;

public class Tienda {
	
	private HashMap<Producto, Integer> stock;
	
	public Tienda() {
		stock = new HashMap<>();
	}
	
	public void añadir (String nombre, int precio, int stock) {
		Producto nuevo = new Producto(nombre, precio);	
		if(!this.stock.containsKey(nuevo)){
			this.stock.put(nuevo, stock);	
		} else {
			System.out.println("Ya existe un producto con esa clave");
		}
	}
	
	public void modificar (String nombre, int precio, int stock) {
		this.stock.put(new Producto(nombre, precio), stock);	
	}
	
	public void borrar (String nombre, int precio) {
		this.stock.remove(new Producto(nombre, precio));	
	}
	
	public void resetear () {
		this.stock.clear();
	}

	@Override
	public String toString() {
		return "Tienda [stock=" + stock + "]";
	}

	
}
