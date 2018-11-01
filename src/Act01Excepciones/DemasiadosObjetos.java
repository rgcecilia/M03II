package Act01Excepciones;

/**
 *
 * @author raulgcecilia
 */

public class DemasiadosObjetos extends Exception {
    
	private static final long serialVersionUID = 1L;
	private int errCode = 0;
	
    public DemasiadosObjetos(String mensaje){
        super(mensaje);
    }
    
    public DemasiadosObjetos(int errCode){
        super();
        this.errCode = errCode;
    }
    public void errores(){
            System.out.println("Demasiados Objetos en el array");
    }
        
}