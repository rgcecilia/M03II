package Act01Excepciones;

/**
 * @author Ra�l Guti�rrez Cecilia
 * @Asignatura DAW M03II
 */

public class DemasiadosObjetos extends Exception {
    
	private static final long serialVersionUID = 1L; 
    
    public DemasiadosObjetos(int errCode){
    	errores(errCode );    
    }
    
    public void errores(int error){
    	if(error == 117) {
            System.out.println("Demasiados Objetos en el array");
    	}else {
    		System.out.println("Error en la construccion del objeto");
    	}    	
    }       
}