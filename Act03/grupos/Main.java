package grupos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class Main {
			
	static ObjectContainer bbdd;
	
	public static void main(String[] args) throws IOException{
	
		int select = 0;
		do{
			select = menu();
			bbdd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "Grupos.db4o");
			switch(select){
			case 1:
				Dao.crearGrupo();
				break;
			case 2:
				Dao.mostrarGrupos();
				break;
			case 3:
				Dao.buscarPorEstilo();
				break;
			case 4:
				Dao.buscarGruposRock();
				break;
			case 5:
				bbdd.close();
				System.out.println("Fin del programa");
				break;
			default:
				System.out.println("Seleccione una opción valida");
			}
		}while(select!=5);

		}
	
	private static int menu() throws NumberFormatException, IOException {
		System.out.println(" Selecciona una opción");
		System.out.println(" 1 -> Crear grupo");
		System.out.println(" 2 -> Mostrar todos los grupos de la base de datos");
		System.out.println(" 3 -> Filtrar grupos por estilo");
		System.out.println(" 4 -> Mostrar todos los grupos de Rock formados por más de 3 miembros");
		System.out.println(" 5 -> Salir");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int selec = Integer.parseInt(br.readLine());
		return selec;
	}
}



