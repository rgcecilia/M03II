/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase1;

/**
 *
 * @author dmorenoar
 */
public class Videojuego {
    /**********************
        Atributos
    **********************/
    
    //CONSULTAR STATIC EN ATRIBUTOS/PROPIEDADESS
    //ID, CONTADOR
    
    private String nombre = "XXX"; //private es el tipo de acceso más restrictivo que existe
    private int anyoSalida = 0; //Valores por defecto
    private String tipo = "Plataforma"; //Valores por defecto
    
    
    /**********************
        Constructores
    **********************/
    //Constructor(Los planos de cómo se va a construir el objeto
    public Videojuego() {} //Constructor por defecto
    
    //Constructor con todos los atributos
    public Videojuego(String nombre, int anyoSalida, String tipo) { 
        this.anyoSalida = anyoSalida;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public Videojuego(String nombre) {
        this.nombre = nombre;
    }
   
    /**********************
        Getters y setters
    **********************/
    
    //Devuelve el nombre del videojuego
    public String getNombre(){ //Utilizamos formato camelCase
        return this.nombre;
    }
    
    public int getAnyoSalida(){
        return this.anyoSalida;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

        
   /**********************
        Métodos propios de la clase
    **********************/
    
    public void eslogan(){
        System.out.println("TODOS A UNA");
    }
    
    public String toString(){
        return "Videojuego:" + this.nombre + "," + anyoSalida + "," + tipo;
    }
 
}
