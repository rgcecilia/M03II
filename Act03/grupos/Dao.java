package grupos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class Dao {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void crearGrupo() throws IOException {		
		System.out.println("Introduce el nombre del grupo:");
		String nombre = br.readLine();
		System.out.println("Introduce estilo:");
		String estilo = br.readLine();
		System.out.println("Introduce el nº de integrantes:");
		int integrantes = Integer.parseInt(br.readLine());
		Grupo grupo = new Grupo(nombre, estilo, integrantes);
		Main.bbdd.store(grupo);	
		System.out.println("Grupo Almacenado Correctamente");
		Main.bbdd.close();
	}
	
	public static void mostrarGrupos() {
		Grupo grupo = new Grupo(null, null, 0);
		ObjectSet result = Main.bbdd.queryByExample(grupo);
		while(result.hasNext()){
			System.out.println(result.next());
		}
		System.out.println("");
		Main.bbdd.close();
	}
	
	public static void buscarPorEstilo() throws IOException {
		System.out.println("Introduce un estilo para buscar:");
		String estilo = br.readLine();
		Query consulta = Main.bbdd.query();
		consulta.constrain(Grupo.class);
		consulta.descend("estilo").constrain(estilo).equal();
		consulta.descend("nombre").orderAscending();
		ObjectSet<?> resultado = consulta.execute();
		if(resultado.size()==0) {
			System.out.println("No hay Grupos");
		}
		while(resultado.hasNext()){
			System.out.println(resultado.next());
		}
		System.out.println("");
		Main.bbdd.close();
	}
	
	public static void buscarGruposRock() {
		Query consulta = Main.bbdd.query();
		consulta.constrain(Grupo.class);
		Constraint cons = consulta.descend("estilo").constrain("Rock");
		consulta.descend("integrantes").constrain(3).greater().and(cons);
		ObjectSet resultado = consulta.execute();
		if(resultado.size()==0) {
			System.out.println("No hay Grupos");
		}
		while(resultado.hasNext()){
			System.out.println(resultado.next());
		}
		System.out.println("");
		Main.bbdd.close();
	}

}
