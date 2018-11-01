/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase5;

/**
 *
 * @author raulgcecilia
 */

public class MeException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errCode = 0;
    
    public MeException(int errCode){
        super();
        this.errCode = errCode;
    }
    
    public MeException(String mensaje){
        super(mensaje);
    }
    /*
    Creo mi propia leyena de errores
    */
    public String errores(){
        String error = "";
        switch(errCode){
            case 404:
                error = "Las muertes no pueden ser menores a 0";
            break;
            case 500:
                error = "Debes especificar el usuario";
            break;
        }
        
        return error;
    }
    
}
