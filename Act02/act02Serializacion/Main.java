/**
 * 
 */
package act02Serializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class Main {

	public static void main(String[] args) {
		Empleado empleado1 = new Empleado("Juan", 25, 1199);
		Empleado empleado2 = new Empleado("Carmen", 30, 1399);
		Empleado empleado3 = new Empleado("Daniel", 35, 1599);
		ArrayList<Empleado> MisEmpleados = new ArrayList<Empleado>();
		MisEmpleados.add(empleado1);
		MisEmpleados.add(empleado2);
		MisEmpleados.add(empleado3);

		try {
			FileOutputStream fs = new FileOutputStream("Empleados.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);									
			os.writeObject(MisEmpleados);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fis = new FileInputStream("Empleados.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			System.out.println(ois.readObject().toString());
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
