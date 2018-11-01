package Act01ArrayList;
import java.io.IOException;
import java.util.ArrayList;

import Act01ArrayList.Trabajo;

public class FuncionesTrabajo {

	public static Trabajo registrarTrabajo() throws IOException {

		Trabajo miTrabajo = new Trabajo();
		int select = 0;
		String descripcion;
		select = Utilidades.pedirEntero("Seleccione el tipo de Trabajo \n"
					+ "1 Mecanica \n"
					+ "2 Pintura \n" 
					+ "3 Revision\n");
			
		descripcion = Utilidades.pedirCadena("Describa el trabajo");
		if (select == 1) {
			miTrabajo = new Mecanica(descripcion,0,0,0,false);
		}
		if (select == 2) {
			miTrabajo = new Pintura(descripcion,0,0,0,false);
		}
		if (select == 3) {
			miTrabajo = new Revision(descripcion,0,0,0,false);
		}

		return miTrabajo;
	}
	
	public static ArrayList<Trabajo> ponerHoras(ArrayList<Trabajo> miArray) throws IOException {
		int idSeleccion = Utilidades.pedirEntero("Indique el id del trabajo al que asignar horas");
		boolean ok = false;
        for(int i=0; i < miArray.size(); i++){
            if(miArray.get(i).getIdTrabajo() == idSeleccion){
            	ok = true;
            	if(miArray.get(i).getFinalizado() == true) {
            		System.out.println("Trabajo finalizado no puedes añadir mas horas \n");
            		break;
            	} else {
	            	double horas = miArray.get(i).getHoras() + Utilidades.pedirDoble("Introduzca el numero de horas trabajadas");
	            	miArray.get(i).setHoras(horas);
	            	double precio = miArray.get(i).getPrecio();
	            	miArray.get(i).setPrecio(precio);
	            	System.out.println(miArray.get(i).getIdTrabajo() +" "+ miArray.get(i).getHoras());
	            	break;
            	} 
            }else{
            	ok = false;
            }
        }
        if(ok = false) {
        	System.out.println("id incorrecto, intentalo de nuevo");
        	ponerHoras(miArray);
        }
		return miArray;  
	}
	
	public static ArrayList<Trabajo> ponerMaterial(ArrayList<Trabajo> miArray) throws IOException {
		int idSeleccion = Utilidades.pedirEntero("Indique el id del trabajo al que añadir el material");
		boolean ok = false;
        for(int i=0; i < miArray.size(); i++){
            if(miArray.get(i).getIdTrabajo() == idSeleccion){	
            	ok = true;
            	double material = miArray.get(i).getMaterial() + Utilidades.pedirDoble("Introduzca el precio del material");
            	miArray.get(i).setMaterial(material);
            	double precio = miArray.get(i).getPrecio();
            	miArray.get(i).setPrecio(precio);
            	break;
            }else {
            	ok = false;
            } 
        }
        if(ok == false) {
        	System.out.println("id incorrecto, intentalo de nuevo");
        	ponerMaterial(miArray);
        }
		return miArray;  
	}
	
	public static ArrayList<Trabajo> finalizarTrabajo(ArrayList<Trabajo> miArray) throws IOException {
		int idSeleccion = Utilidades.pedirEntero("Indique el id del trabajo a modificar");
		boolean ok = false;
        for(int i=0; i < miArray.size(); i++){
        	ok = true;
            if(miArray.get(i).getIdTrabajo() == idSeleccion){     
            	miArray.get(i).setFinalizado(true);    
            	break;
            }else {
            	ok = false;
            }
        }
        if(ok == false) {
        	System.out.println("id incorrecto, intentalo de nuevo");
        	finalizarTrabajo(miArray);
        }
		return miArray;  
	}
	
	public static void mostrarTrabajo(ArrayList<Trabajo> miArray) throws IOException {
		int idSeleccion = Utilidades.pedirEntero("Indique el id del trabajo a mostrar");
		boolean ok = false;
        for(int i=0; i < miArray.size(); i++){
            if(miArray.get(i).getIdTrabajo() == idSeleccion){  
            	ok = true;
            	System.out.println(miArray.get(i).getIdTrabajo() + "\n" 
            			         + miArray.get(i).getDescripcion() + "\n"
            			         + miArray.get(i).getPrecio());
            	break;
            }else {
            	ok = false;
            }           
        }
        if(ok == false) {
        	System.out.println("id incorrecto, intentalo de nuevo");
        	finalizarTrabajo(miArray);
        }  
	}
}
