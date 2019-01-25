package Act01Excepciones;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */

public class DemasiadosObjetos extends Exception {

    public DemasiadosObjetos(String errCode){
    	super(errCode);    
    }
           
}