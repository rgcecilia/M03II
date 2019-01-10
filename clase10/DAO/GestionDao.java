/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Entrenador;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Daniel Moreno
 */
public class GestionDao {
    
    public ObjectContainer db;
    
    /*Creamos el contenedor para poder trabajar con el fichero BD*/
    public GestionDao(){
        db = Db4oEmbedded.openFile("ligapokemon");
    }
    
    public void insertarEntrenador(Entrenador e){
        db.store(e);
    }
    
    public List<Entrenador> selectAllEntrenadores(){
        
        /*SELECT * FROM ENTRENADOR
          QUERY = SELECT
          QUERY.CONSTRAINT = FROM ENTRENADOR  
        */
        
        List<Entrenador> entrenadores = new ArrayList();
        Query query = db.query(); //Creamos la query
        query.constrain(Entrenador.class); //Indicamos la clase del objeto a consultar
        //Obtenemos todos los que cumplan la condición de ser de la clase Entrenador
        ObjectSet resultado = query.execute(); 
        
        while(resultado.hasNext()){
            Entrenador e = (Entrenador) resultado.next();
            entrenadores.add(e);
        }
        
        return entrenadores;
        
    }
    /*Pendiente de repasar*/
    public List<Entrenador> selectAllEntrenadoresOrderedByCollections(){
        List<Entrenador> entrenadores = selectAllEntrenadores();
        //Collections.sort(entrenadores, Collections.reverseOrder()); //Para ordenar descendientemente
        Collections.sort(entrenadores); //Para ordenar ascendientemente
        return entrenadores;
    }
    
    public List<Entrenador> selectAllEntrenadoresOrdered(){

        List<Entrenador> entrenadores = new ArrayList();
        Query query = db.query(); //Creamos la query
        query.constrain(Entrenador.class); //Indicamos la clase del objeto a consultar
        query.descend("nombre").orderAscending();
        //Obtenemos todos los que cumplan la condición de ser de la clase Entrenador
        ObjectSet resultado = query.execute(); 
        
        while(resultado.hasNext()){
            Entrenador e = (Entrenador) resultado.next();
            entrenadores.add(e);
        }
        
        return entrenadores;
        
    }
    
    
    public List<Entrenador> selectAllEntrenadoresByRange(int edad){
        /*SELECT * FROM ENTRENADOR WHERE EDAD > edad
        
        QUERY DESCEND = WHERE EDAD
        CONSTRAINT EDAD GREATER = > edad
        */
        List<Entrenador> entrenadores = new ArrayList();
        Query query = db.query(); //Creamos la query
        query.constrain(Entrenador.class); //Indicamos la clase del objeto a consultar
        query.descend("edad").constrain(edad).greater();
        //Obtenemos todos los que cumplan la condición de ser de la clase Entrenador
        ObjectSet resultado = query.execute(); 
        
        while(resultado.hasNext()){
            Entrenador e = (Entrenador) resultado.next();
            entrenadores.add(e);
        }
        
        return entrenadores;
        
        
    }
    
    public void desconectar(){
        db.close();
        File f = new File("ligapokemon");
        f.delete();
}
}
