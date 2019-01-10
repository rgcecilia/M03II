/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase3;

/**
 *
 * @author dmorenoar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Creo un array de la clase más alta de la jerarquía
        Persona[] listaPersonas = new Persona[10];
        
        /*
            Persona             Persona
                Matricular          Maestro
                    Alumno
        */
        
        
        Maestro ma = new Maestro(1000);
        
        Maestro maVIP = new Maestro(50000, 3);
        
        Alumno alu = new Alumno("Pepe", 55, 'H', 5);
        
        //Introduzco a un maestro y un alumno porque heredan de la clase Persona
        listaPersonas[0] = ma;
        listaPersonas[1] = alu;
        
        
        alu.saludar();
        
        maVIP.saludar();

        //Ahora puedo acceder a los métodos del padre
        //System.out.println("Dime tu nombre:" + ma.getEdad());
        
        
        
        //String es por si solo un Wrappe(Clase envoltorio)
        
        
        //Datos primitivos
       
        
     
        /*
        Clase -> Padre/Madre
            SubClase -> Hijo/Hija
                    
        Clase -> Abuelo/Abuela
           Subclase de Abuelo y Clase de Hijo -> Padre/Madre
                   Subclase de Padre -> Hijo/Hija
        */
        /*
        Clase -> Empleado (propiedad: Sueldo, método: cobrar())
        
        SubClase -> TrabLog (heredaré la propiedad sueldo y cobrar(500))
        
        SubClase -> TrabMark (heredaré la propiedad sueldo y cobrar(800), viajar())
        */
    }
    
}
