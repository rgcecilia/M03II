package Act01Excepciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

	public static int contador;
	
	/**Funcion para pedir un numero entero al usuario.
	 * @param p, Cadena de texto con una pregunta para el usuario.
	 * @return x, Entero introducido por consola por el usuario.
	 * @throws IOException
	 */
	public static int pedirEntero(String p) throws IOException {
		int x = 0;
		System.out.println(p);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			x = Integer.parseInt(br.readLine());
		} catch (NumberFormatException Ex) {
			System.out.println("No has indicado un valor entero");
			contador ++;
			if(contador > 5) {
				System.out.println("Has cometido mas de 5 errores, FIN DEL PROGRAMA");
				System.exit(contador);
			}
			pedirEntero("Intentalo de nuevo");
		}
		return x;
	}
	
	/**Funcion para pedir un numero decimal al usuario.
	 * @param p, Cadena de texto con una pregunta para el usuario.
	 * @return x, Double introducido por consola por el usuario.
	 * @throws IOException
	 */
	public static double pideDouble(String text) throws IOException {
		double d = 0;
		System.out.print(text);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cadena = br.readLine();
		try {
			d = Double.parseDouble(cadena);
		} catch (NumberFormatException Ex) {
			System.out.println("Valor no valido, intentelo de nuevo");
			contador ++;
			if(contador > 5) {
				System.out.println("Has cometido mas de 5 errores, FIN DEL PROGRAMA");
				System.exit(contador);
			}
			pideDouble(text);
		}
		return d;
	}

	/**Funcion para pedir una cadena de texto al usuario.
	 * @param p, Cadena de texto con una pregunta para el usuario.
	 * @return cadena, Cadena de texto introducida por el usuario.
	 * @throws IOException
	 */
	public static String pedirCadena(String p) throws IOException {
		System.out.println(p);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cadena = br.readLine();
		if(cadena.matches(".*[0-9].*")){
			System.out.println("No puedes Introducir numeros en el nombre");
			contador ++;
			if(contador > 5) {
				System.out.println("Has cometido mas de 5 errores, FIN DEL PROGRAMA");
				System.exit(contador);
			}
			pedirCadena("Intentalo de nuevo");
			
		}
		return cadena;
	}
}
