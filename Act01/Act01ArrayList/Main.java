package Act01ArrayList;

import java.io.IOException;
import Act01ArrayList.Trabajos;
import Act01ArrayList.Utilidades;


public class Main {

	public static void main(String[] args) throws IOException {
		
		Trabajos misTrabajos = new Trabajos();
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
					misTrabajos.registrarTrabajo();
					break;
				case 2:
					misTrabajos.ponerHoras();
					break;
				case 3:
					misTrabajos.ponerMaterial();
					break;
				case 4:
					misTrabajos.finalizarTrabajo();
					break;
				case 5:
					misTrabajos.mostrarTrabajo();
					break;
				case 6:
					System.out.println("Bye");
					System.exit(0);
					break;
				default:
					System.out.println("Seleccion no valida, intentelo de nuevo");
					break;
			}

		} while (selec > 0 | selec < 7);

	}

}

