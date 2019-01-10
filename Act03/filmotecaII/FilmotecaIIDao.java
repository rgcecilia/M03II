package filmotecaII;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class FilmotecaIIDao {
		
	//Horario useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
	private String url= "jdbc:mysql://localhost:3306/filmotecaII?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	//Usuario
    private String user = "root";
    //Contraseña
    private String pass = "12345";
	private Connection conexion;
	    
	public FilmotecaIIDao() {
		try {
	        conexion = DriverManager.getConnection(url, user, pass);
			}catch (SQLException e) {
				e.printStackTrace();
			}   
	    }
	       
    public ArrayList<Pelicula> listaPeliculas(){
        ArrayList<Pelicula> misPeliculas = new ArrayList<Pelicula>();
        String select = "SELECT * FROM Pelicula";
        Statement st = null;
        ResultSet rs = null;
        try {
	        st = conexion.createStatement();
	        rs = st.executeQuery(select);
	        
	        while(rs.next()){
	            Pelicula p = new Pelicula();
	            p.setId(rs.getInt("id"));
	            p.setTitulo(rs.getString("titulo"));
	            p.setDirector(rs.getInt("director"));
	            p.setPais(rs.getString("pais"));
	            p.setDuracion(rs.getString("duracion"));
	            p.setGenero(rs.getString("genero"));
	            misPeliculas.add(p);      
	        }		        
	        rs.close();
	        st.close();         
        }catch (SQLException e) {
			e.printStackTrace();
		}   
        return misPeliculas;    
    }
    
    public ArrayList<Pelicula> listaPeliculas(String director, String genero){
    	ArrayList<Pelicula> peliculasFiltradas = new ArrayList<Pelicula>();
    	ArrayList<Director> directores = listarDirector();
    	String selectDir = null;
    	int idDirector = 0;
    	Statement st = null;
        ResultSet rs = null;
        String select = "";
        
        ArrayList<Pelicula> misPeliculas = new ArrayList<Pelicula>();
        if (director == "" && genero != "") {
        	select = "Select * from Pelicula Where genero = '"+genero+"';";
        }
        if (genero == "" && director !="") {
        	for(int i=0; i<(directores.size());i++) {
        		if(directores.get(i).getNombre().equals(director)) {
        			idDirector = directores.get(i).getId();
        			break;
        		}		
        	}
        	select = "Select * from Pelicula Where director = '"+idDirector+"';";
        }	
        if (director != "" && genero != "") {
        	for(int i=0; i<(directores.size());i++) {
        		if(directores.get(i).getNombre().equals(director)) {
        			idDirector = directores.get(i).getId();
        			break;
        		}		
        	}
        	select = "Select * from Pelicula Where director = '"+idDirector+"' and genero = '"+genero+"';";
        }
        try {
	        st = conexion.createStatement();
	        rs = st.executeQuery(select);
	        
	        while(rs.next()){
	            Pelicula p = new Pelicula();
	            p.setId(rs.getInt("id"));
	            p.setTitulo(rs.getString("titulo"));
	            p.setDirector(rs.getInt("director"));
	            p.setPais(rs.getString("pais"));
	            p.setDuracion(rs.getString("duracion"));
	            p.setGenero(rs.getString("genero"));
	            misPeliculas.add(p);      
	        }		        	                
        }catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				rs.close();
		        st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return misPeliculas;    
    }
	    
	    public ArrayList<Director> listarDirector(){
	        ArrayList<Director> misDirectores = new ArrayList<Director>();
	        String select = "SELECT * FROM director";
	        Statement st = null;
	        ResultSet rs = null;
	        try {
		        st = conexion.createStatement();
		        rs = st.executeQuery(select);
		        while(rs.next()){
		            Director d = new Director();
		            d.setId(rs.getInt("id"));
		            d.setNombre(rs.getString("nombre"));
		            misDirectores.add(d);      
		        }		             
	        }catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try{
					rs.close();
			        st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}   
	        return misDirectores;    
	    }	            
	        
		public void eliminarDirector(int idDirector){
			String query = "delete from director where id = " + idDirector + ";";
			Statement st = null;
			try {
				st = conexion.createStatement();
				st.executeUpdate(query);
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try{
			        st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		}
		
		public void crearDirector(String nombre){
			String query = "insert into director values (NULL,'" + nombre + "');";
			Statement st = null;
			try {
				st = conexion.createStatement();
				st.executeUpdate(query);
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try{
			        st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
		}
		
		public void modificarDirector(int id,String nombre){
			String query = "update director set nombre = '"+nombre+"' where id = "+id+";";
			Statement st = null;
			try {
				st = conexion.createStatement();
				st.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try{
			        st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
		
		public void eliminarPelicula(int idPelicula){
			String query = "delete from Pelicula where id = " + idPelicula + ";";
			Statement st = null;
			try {
				st = conexion.createStatement();
				st.executeUpdate(query);
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try{
			        st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
	    
		public void crearPelicula(String nombre, int director, String pais, String duracion, String genero){
			String query = "insert into Pelicula values (NULL,'" + nombre + "'," + director + ",'"+ pais +"','" + duracion + "','" + genero + "');";
			Statement st = null;
			try {
				st = conexion.createStatement();
				st.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try{
			        st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
		}
		
		public void modificarPelicula(int id, String titulo, int director, String pais, String duracion, String genero){
			String query = "update Pelicula set titulo = '"+ titulo +"', director = "+director+",pais = '"+ pais +"',duracion = '"+ duracion +"',genero = '"+ genero +"' where id = "+id+";";
			Statement st = null;
			try {
				st = conexion.createStatement();
				st.executeUpdate(query);
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try{
			        st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
		
		public ArrayList<Genero> listarGeneros(){
			ArrayList<Genero> misGeneros = new ArrayList<Genero>();
	        String select = "SELECT distinct genero from pelicula";
	        Statement st = null;
	        ResultSet rs = null;
	        try {
		        st = conexion.createStatement();
		        rs = st.executeQuery(select);
		        while(rs.next()){
		            misGeneros.add(new Genero(rs.getString(1)));      
		        }		        
	        }catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try{
					rs.close();
			        st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	        return misGeneros;    
	    }
}
