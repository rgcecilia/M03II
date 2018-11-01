package Act01ArrayList;

import java.io.IOException;
import java.util.ArrayList;
import Act01ArrayList.FuncionesTrabajo;
import Act01ArrayList.Utilidades;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Trabajo trabajo;
		ArrayList<Trabajo> listaTrabajos = new ArrayList<Trabajo>();
		int selec = 0;
		do {
			selec = Utilidades.pedirEntero("Seleccione una opcion \n"
					+ "1 Registrar Trabajo \n"
					+ "2 Aumentar Horas a un Trabajo \n" 
					+ "3 Aumentar Coste Piezas\n" 
					+ "4 Finalizar Trabajo \n" 
					+ "5 Mostrar Trabajo \n"
					+ "6 Finalizar Programa");
			
			switch (selec) {
				case 1:
					trabajo = FuncionesTrabajo.registrarTrabajo();
					listaTrabajos.add(trabajo);
					System.out.println("Trabajo registrado con el id: " + trabajo.getIdTrabajo());
					break;
				case 2:
					listaTrabajos = FuncionesTrabajo.ponerHoras(listaTrabajos);
					break;
				case 3:
					listaTrabajos = FuncionesTrabajo.ponerMaterial(listaTrabajos);
					break;
				case 4:
					listaTrabajos = FuncionesTrabajo.finalizarTrabajo(listaTrabajos);
					break;
				case 5:
					FuncionesTrabajo.mostrarTrabajo(listaTrabajos);
					break;
				case 6:
					System.out.println("Bye");
					System.exit(6);
					break;
				default:
					System.out.println("Seleccion no valida, intentelo de nuevo");
					break;
			}

		} while (selec > 0 | selec < 7);

	}

}

