package Act01ArrayList;
import java.io.IOException;
import java.util.ArrayList;

import Act01ArrayList.Trabajo;

public class Trabajos {

	private ArrayList<Trabajo> misTrabajos;
		
	public Trabajos() {
		super();
		this.misTrabajos = new ArrayList<Trabajo>();
	}

	public void registrarTrabajo() throws IOException {

		Trabajo trabajo = new Trabajo();
		int select = 0;
		String descripcion;
		select = Utilidades.pedirEntero("Seleccione el tipo de Trabajo \n"
					+ "1 Mecanica \n"
					+ "2 Pintura \n" 
					+ "3 Revision\n");
			
		descripcion = Utilidades.pedirCadena("Describa el trabajo");
		if (select == 1) {
			trabajo = new Mecanica(descripcion,0,0,0,false);
		}
		if (select == 2) {
			trabajo = new Pintura(descripcion,0,0,0,false);
		}
		if (select == 3) {
			trabajo = new Revision(descripcion,0,0,0,false);
		}

		misTrabajos.add(trabajo);
		System.out.println("Trabajo registrado con el id: " + trabajo.getIdTrabajo());
	}
	
	public void ponerHoras() throws IOException {
		int idSeleccion = Utilidades.pedirEntero("Indique el id del trabajo al que asignar horas");
		boolean ok = false;
        for(int i=0; i < misTrabajos.size(); i++){
            if(misTrabajos.get(i).getIdTrabajo() == idSeleccion){
            	ok = true;
            	if(misTrabajos.get(i).getFinalizado() == true) {
            		System.out.println("Trabajo finalizado no puedes añadir mas horas \n");
            		break;
            	} else {
	            	double horas = misTrabajos.get(i).getHoras() + Utilidades.pedirDoble("Introduzca el numero de horas trabajadas");
	            	misTrabajos.get(i).setHoras(horas);
	            	double precio = misTrabajos.get(i).getPrecio();
	            	misTrabajos.get(i).setPrecio(precio);
	            	System.out.println(misTrabajos.get(i).getIdTrabajo() +" "+ misTrabajos.get(i).getHoras());
	            	break;
            	} 
            }else{
            	ok = false;
            }
        }
        if(ok == false) {
        	System.out.println("id incorrecto, intentalo de nuevo");
        	ponerHoras();
        }
	}
	
	public void ponerMaterial() throws IOException {
		int idSeleccion = Utilidades.pedirEntero("Indique el id del trabajo al que añadir el material");
		boolean ok = false;
        for(int i=0; i < misTrabajos.size(); i++){
            if(misTrabajos.get(i).getIdTrabajo() == idSeleccion){	
            	ok = true;
            	double material = misTrabajos.get(i).getMaterial() + Utilidades.pedirDoble("Introduzca el precio del material");
            	misTrabajos.get(i).setMaterial(material);
            	double precio = misTrabajos.get(i).getPrecio();
            	misTrabajos.get(i).setPrecio(precio);
            	break;
            }else {
            	ok = false;
            } 
        }
        if(ok == false) {
        	System.out.println("id incorrecto, intentalo de nuevo");
        	ponerMaterial();
        } 
	}
	
	public void finalizarTrabajo() throws IOException {
		int idSeleccion = Utilidades.pedirEntero("Indique el id del trabajo a modificar");
		boolean ok = false;
        for(int i=0; i < misTrabajos.size(); i++){
        	ok = true;
            if(misTrabajos.get(i).getIdTrabajo() == idSeleccion){     
            	misTrabajos.get(i).setFinalizado(true);    
            	break;
            }else {
            	ok = false;
            }
        }
        if(ok == false) {
        	System.out.println("id incorrecto, intentalo de nuevo");
        	finalizarTrabajo();
        }
	}
	
	public void mostrarTrabajo() throws IOException {
		int idSeleccion = Utilidades.pedirEntero("Indique el id del trabajo a mostrar");
		boolean ok = false;
        for(int i=0; i < misTrabajos.size(); i++){
            if(misTrabajos.get(i).getIdTrabajo() == idSeleccion){  
            	ok = true;
            	System.out.println(misTrabajos.get(i).getIdTrabajo() + "\n" 
            			         + misTrabajos.get(i).getDescripcion() + "\n"
            			         + misTrabajos.get(i).getPrecio());
            	break;
            }else {
            	ok = false;
            }           
        }
        if(ok == false) {
        	System.out.println("id incorrecto, intentalo de nuevo");
        	finalizarTrabajo();
        }  
	}
}
