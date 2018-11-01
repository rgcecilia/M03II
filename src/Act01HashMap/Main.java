package Act01HashMap;

public class Main {

	public static void main(String[] args) {
		
		Tienda miTienda = new Tienda();
		
		System.out.println("A�adimos Productos y su Stock al HashMap \n");
		
		miTienda.a�adir("Camiseta", 10, 10);
		miTienda.a�adir("Calzonas", 15, 6);
		miTienda.a�adir("Chaqueta", 20, 10);
		miTienda.a�adir("Pantalon", 25, 8);
		
		System.out.println("Comprobamos el contenido del HashMap \n"
							+ miTienda + "\n"
							+ "Modificamos Productos y su Stock en el HashMap \n");
		
		miTienda.modificar("Camiseta", 10, 15);
		miTienda.modificar("Calzonas", 15, 12);
		
		System.out.println("Comprobamos el contenido del HashMap \n"
							+ miTienda + "\n"
							+ "Eliminamos Productos del HashMap \n");
		
		miTienda.borrar("Camiseta", 10);
		miTienda.borrar("Calzonas", 15);
		
		
		System.out.println("Comprobamos el contenido del HashMap \n"
							+ miTienda + "\n"
							+ "Intentamos operar con dos Productos iguales HashMap \n");
		
		miTienda.a�adir("Chaqueta", 20, 15);
		miTienda.a�adir("Pantalon", 20, 15);
		
		System.out.println("Comprobamos el contenido del HashMap \n"
							+ miTienda + "\n \n"
							+ "Borramos el HashMap \n");
		
		miTienda.resetear();
		
		System.out.println("Comprobamos el contenido del HashMap \n"
				+ miTienda + "\n");
		
		
	}
}
