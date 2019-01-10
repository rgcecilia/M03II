/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkia_1819_m03_uf5_c10;

import DAO.GestionDao;
import Models.Entrenador;
import Models.Pokemon;
import java.util.List;

/**
 *
 * @author Daniel Moreno
 */
public class LINKIA_1819_M03_UF5_C10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GestionDao ligaDao = new GestionDao();

        Entrenador ash = new Entrenador("Ash", "+3412345", "Hombre", 2, 2, "Eléctrico");
        Entrenador brock = new Entrenador("Brock", "+340101", "Hombre", 5, 6, "Roca");
        Entrenador z = new Entrenador("z", "+340101", "Hombre", 5, 6, "Roca");

        Pokemon pikachu = new Pokemon("Pikachu", "Eléctrico", 22, ash);
        Pokemon onix = new Pokemon("Onix", "Roca", 22, brock);

        //Testeando insertar un Entrenador
        System.out.println("!!!!!Testeando insertar entrenador!!!!!");
        insertarEntrenador(ligaDao, ash);
        insertarEntrenador(ligaDao, brock);
        insertarEntrenador(ligaDao, z);

        //Testeando seleccionar todos los Entrenadores
        System.out.println("!!!!!Testeando seleccionar entrenadores desordenados!!!!!");
        for (Entrenador e : seleccionarAllEntrenadores(ligaDao)) {
            System.out.println(e);
        }

        //Testeando modificar los datos de un Entrenador
        
        
        //Testeando ordenar los Entrenadores
        System.out.println("!!!!!Testeando seleccionar entrenadores ordenados!!!!!");
        for (Entrenador e : seleccionarAllEntrenadoresOrdered(ligaDao)) {
            System.out.println(e);
        }
        //Testeando ordenar los Entrenadores con Collections
        System.out.println("!!!!!Testeando seleccionar entrenadores ordenados con Collections!!!!!");
         for (Entrenador e : selectAllEntrenadoresOrderedByCollections(ligaDao)) {
            System.out.println(e);
        }
        

        //Testeando seleccionar entrenador por nombre
        //Testeando seleccionar entrenador por rango de edad
        System.out.println("!!!!!Testeando seleccionar entrenadores con edad > 3!!!!!");
        for (Entrenador e : seleccionarEntrenadoresByRange(ligaDao, 3)) {
            System.out.println(e);
        }

        //Cierro la conexion y borro la BD
        //ligaDao.desconectar();
        
        
        //Testeando insertar un Pokemon
    }

    public static void insertarEntrenador(GestionDao ligaDao, Entrenador e) {
        ligaDao.insertarEntrenador(e);
        System.out.println("Entrenador insertado correctamente");
    }

    public static List<Entrenador> seleccionarAllEntrenadores(GestionDao ligaDao) {
        return ligaDao.selectAllEntrenadores();
    }

    public static List<Entrenador> seleccionarAllEntrenadoresOrdered(GestionDao ligaDao) {
        return ligaDao.selectAllEntrenadoresOrdered();
    }
    
     public static List<Entrenador> selectAllEntrenadoresOrderedByCollections(GestionDao ligaDao) {
        return ligaDao.selectAllEntrenadoresOrderedByCollections();
    }

    public static List<Entrenador> seleccionarEntrenadoresByRange(GestionDao ligaDao, int edad) {
        return ligaDao.selectAllEntrenadoresByRange(edad);
    }

      
}

