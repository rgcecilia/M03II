/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author dmorenoar
 */
public class LINKIA_1819_M03_UF4_C05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String pal = "aaa";

        try {

            //Tools.pideEntero();
            Dinosaurio dino = new Dinosaurio("TRex","Carnívoro");
            
            dino.setMuertes(-10);
            
        } catch (MeException e) {
            System.out.println(e.errores());
        } finally {
            System.out.println("Me ejecuto si o si");
        }

    }

   

}
