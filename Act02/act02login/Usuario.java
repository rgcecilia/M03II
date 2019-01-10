/**
 * 
 */
package act02login;

import java.io.Serializable;

/**
 * @author Ra�l Guti�rrez Cecilia
 * @Asignatura DAW M03II
 */
public class Usuario implements Serializable {
	
	private String nombre;
	private String password;
	public Usuario(String nombre, String password) {
		
		this.nombre = nombre;
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", password=" + password + "]";
	}
	
	
}
