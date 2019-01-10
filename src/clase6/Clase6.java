/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase6;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmorenoar
 */
public class Clase6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        /*LECTURA DE FICHERO CON FILEWRITER Y FILEREADER*/

        try {

            File fichero = new File("apuntes");

            if (fichero.exists()) {
                System.out.println("El fichero existe");
            } else {
                BufferedWriter buffWriter = new BufferedWriter(new FileWriter(fichero));
            }

            leerFichero(fichero);

            String mensaje = "pepe 123456\n";

            escribirFichero(fichero, mensaje);

            leerFichero(fichero);

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        
        
        //LECTURA Y ESCRITURA DE OBJETOS CON SERIALIZACIÓN
        
        Videojuego mario = new Videojuego("Super Mario Bross", 99, "Plataforma");
        Videojuego zelda = new Videojuego("The legend of Zelda", 150, "RPG");
        
        //List<Videojuego>
        //Creación del fichero videojuegos
        File videojuegos = new File("videojuegos");
        
        //Escritura de un objeto en el fichero
        ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(videojuegos));
        //oos.writeObject(mario);
        //oos.writeObject(zelda);
        //oos.close();
        
        //Leemos de un objeto en fichero
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(videojuegos));
        //Videojuego vr = (Videojuego) ois.readObject(); //Casteamos la lectura al objeto esperado
        //System.out.println(vr);
        
        List<Videojuego> lista = new ArrayList();
        lista.add(mario);
        lista.add(zelda);
        
        //Guardo directamente el array con todos los videojuegos
        oos.writeObject(lista);
        oos.close();
        
        //Recupero el array con todos los videojuegos
        List<Videojuego> listaRecuperada = new ArrayList();
        listaRecuperada = (List<Videojuego>) ois.readObject();
        
        //Es importante conocer la clase del objeto que leo para hacer determinadas acciones con el.
        //System.out.println(ois.readObject().getClass());
        
        ois.close();
        
        for (Videojuego v : listaRecuperada) {
            System.out.println(v);
        }
        
        //LECTURA Y ESCRITURA CON XMLENCODER Y XMLDECODER
        /*SOLUCIÓN DEL ERROR:  EL PROBLEMA ESTABA EN QUE LA CLASE VIDEOJUEGO
        NO IMPLEMENTABA EL CONSTRUCTOR POR DEFECTO QUE NECESITA XMLENCODER
        PARA TRABAJAR CON LA CLASE Y POR ESO SAL�?A UN ERROR REFERENTE A LA CLASE
        VIDEOJUEGO EN LAS EXCEPCIONES. LA SOLUCIÓN ES TAN F�?CIL CÓMO CREAR
        EL CONSTRUCTOR public Videojuego(){} EN LA CLASE.*/
   
        //Guardamos información
        XMLEncoder xmlEn = new XMLEncoder(new FileOutputStream(new File("videojuegosXML.xml")));

        xmlEn.writeObject(lista);
        xmlEn.close();

        XMLDecoder xmlDe = new XMLDecoder(new BufferedInputStream(new FileInputStream("videojuegosXML.xml")));

        List<Videojuego> listaXML = (List<Videojuego>) xmlDe.readObject();
        xmlDe.close();

        for (Videojuego v : listaXML) {
            System.out.println(v);
        }

    }

    public static void escribirFichero(File fichero, String mensaje) throws IOException {
        FileWriter frWriter = new FileWriter(fichero, true);
        frWriter.write(mensaje);
        frWriter.flush();
        frWriter.close();
    }

    /*
    Desc: Lee de un fichero y muestra por pantalla su contenido
    Input: Recibe el File del main
    Output: No requiere
     */
    public static void leerFichero(File fichero) throws FileNotFoundException, IOException {
        String cadena = "";

        //Asociamos al FileReader la lectura del fichero
        FileReader frFile = new FileReader(fichero);
        //Asociamos el FileReader al buffer para poder obtener la info del fichero
        BufferedReader brFile = new BufferedReader(frFile);

        //Recogemos los valores mientras en el fichero el buffer encuentre líneas a leer
        while ((cadena = brFile.readLine()) != null) {
            System.out.println(cadena);
        }

        brFile.close(); //Cerrar siempre después de finalizar la lectura
    }

}
