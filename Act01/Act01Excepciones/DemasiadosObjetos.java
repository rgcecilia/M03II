package Act01Excepciones;

/**
 * @author Ra�l Guti�rrez Cecilia
 * @Asignatura DAW M03II
 */

public class DemasiadosObjetos extends Exception {

    public DemasiadosObjetos(String errCode){
    	super(errCode);    
    }
           
}