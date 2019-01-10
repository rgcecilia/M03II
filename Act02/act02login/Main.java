package act02login;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import clase6.Videojuego;


/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Usuario> misUsuarios = new ArrayList<Usuario>();
		Usuario user = new Usuario("USER","12345");
		misUsuarios.add(user);
		
		try {
			FileOutputStream fs = new FileOutputStream("usuarios.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);									
			os.writeObject(misUsuarios);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Login miVentana = new Login();
		
	}

}
