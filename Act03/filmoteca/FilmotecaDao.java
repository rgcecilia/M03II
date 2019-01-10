package filmoteca;

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
public class FilmotecaDao {	
	
	//Horario useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
	private String url= "jdbc:mysql://localhost:3306/filmoteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	//Usuario
	private String user = "root";
	//Contraseña
	private String pass = "12345";
	private Connection conexion;
    
	public FilmotecaDao() {
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
		            p.setTitulo(rs.getString("titulo"));
            p.setDirector(rs.getString("director"));
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
}
