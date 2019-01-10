/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmorenoar
 */
public class Main {

    public static void main(String[] args) {

        Coche c = new Coche("Suzuki", 110); //1
        Coche c2 = new Coche("Volkswagen", 150); //2

        int[] numero = new int[6]; //[1,2,3,4,5,6]

        numero[0] = 1;
        //Sólo guaradré objetos del tipo Coche
        Coche[] listaCoches = new Coche[5];

        listaCoches[0] = c;
        listaCoches[1] = c2;

        for (int i = 0; i < listaCoches.length; i++) {
            System.out.println(listaCoches[i]);
            //System.out.println(listaCoches[i].getMarca()); 
            //En la primera vuelta -> c.getMarca();
            //En la segunda vuelta -> c2.getMarca();
        }

        //Hago una referencia al objeto c3 pero no una copia
        Coche c3 = c; //No es crear un coche es referenciarlo

        System.out.println("Dime tu marca:" + c3.getMarca());

        //Cambio el nombre al coche c pero le afecta al C3
        c.setMarca("Audi");

        System.out.println("Dime tu marca:" + c3.getMarca());

        if (c3.equals(c)) { //Me dice que son iguales porque son referencias al mismo objeto
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }

        try {
            //Un cast de un objeto del tipo Object a Coche
            Coche c4 = (Coche) c.clone(); //3
            System.out.println(c4.getMarca());
            c4.setMarca("Nueva Marca");
            System.out.println(c4.getMarca());
            
            
            if (c4.equals(c)) { //Me dice que no son iguales
                System.out.println("Son iguales");
            } else {
                System.out.println("No son iguales");
            }

            System.out.println(c4.getClass());
            
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        Coche c5 = new Coche("Citroen",52);
        System.out.println("Cual es tu id C4?" + c.getIdentificadorCoche());
        System.out.println("Cual es tu id C5?" + c5.getIdentificadorCoche());

        
    }

}
