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
public class LINKIA_1819_M03_UF4_C01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        //Crear un videojuego(objeto) de la clase(Videjuego) vacío.
        Videojuego ff7 = new Videojuego();
        
        
        Videojuego metalGear = new Videojuego("Metal Gear", 1998, "Acción");
     
        
        System.out.println("Oye cómo te llamas:" + metalGear.getNombre() + 
                " y tu año de salida " + metalGear.getAnyoSalida());
        
        metalGear.setNombre("Metal Gear Gold Edition"); //Modifico el objeto
        
        System.out.println("Oye cómo te llamas ahora:" + metalGear.getNombre());
    
        /*Al mostrar la información sale la de los atributos por defecto, 
        ya qué se crea con el constructor por defecto que no recibe nada*/
        System.out.println("FF7 salio en el año " + ff7.getAnyoSalida() + 
                "Tu nombre es " + ff7.getNombre()); 
        
        ff7.setNombre("Final Fantasy VII");
        
        System.out.println("FF7 salio en el año " + ff7.getAnyoSalida() + 
                "Tu nombre es " + ff7.getNombre());
        
        System.out.println(ff7.toString());
    }
    
}
