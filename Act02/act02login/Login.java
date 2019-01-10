package act02login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class Login extends JFrame {
	
	private JTextField user;
	private JPasswordField password;
	private JLabel incorrecto;
	private JLabel vacio;
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LOGIN");
		getContentPane().setLayout(null);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario: ");
		lblNombreDeUsuario.setBounds(20, 40, 150, 25);
		getContentPane().add(lblNombreDeUsuario);
		
		user = new JTextField();
		user.setBounds(150, 40, 200, 25);
		getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(20, 70, 150, 25);
		getContentPane().add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(150, 70, 200, 25);
		getContentPane().add(password);
		
		JButton iniciarSesion = new JButton("Iniciar Sesion");
		iniciarSesion.addActionListener(new IniciarSesion());
		iniciarSesion.setBounds(120, 150, 160, 30);
		getContentPane().add(iniciarSesion);
		
		incorrecto = new JLabel("Credendiales incorrectas");
		incorrecto.setBounds(125, 110, 160, 25);
		getContentPane().add(incorrecto);
		this.incorrecto.setVisible(false);
		this.incorrecto.setForeground(Color.RED);
		
		vacio = new JLabel("Debes introducir los datos");
		vacio.setBounds(125, 110, 160, 25);
		getContentPane().add(vacio);
		this.vacio.setVisible(false);
		this.vacio.setForeground(Color.RED);
				
		setVisible(true );
		setSize(400,250);
		setLocationRelativeTo(null);
		
	}
	
	public JTextField getUser() {
		return user;
	}
	public void setUser(JTextField user) {
		this.user = user;
	}
	
	private class IniciarSesion implements ActionListener {
		
		List<Usuario> misUsuarios = new ArrayList<Usuario>();
		
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			
		try {
			FileInputStream fis = new FileInputStream("usuarios.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			misUsuarios = (List<Usuario>) ois.readObject();
			ois.close();
			fis.close();
		}catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		vacio.setVisible(false);
		incorrecto.setVisible(false);
		boolean userCorrecto = false;
		char[] imputPassword = password.getPassword();
		String pass = new String(imputPassword); 
		
		for(Usuario u : misUsuarios) {
			if(u.getNombre().equals(user.getText()) && u.getPassword().equals(pass)) {
				userCorrecto = true;
				break;
				}
			}
			
			if( user.getText().length() == 0 || pass.length()  == 0 ) {
				vacio.setVisible(true);
			}
			else if(userCorrecto) {
				new Bienvenida(Login.this);	
				dispose();
			} 
			else {
				incorrecto.setVisible(true);
			}
		}
	
	}
}


