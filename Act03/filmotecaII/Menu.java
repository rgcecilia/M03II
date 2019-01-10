package filmotecaII;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class Menu extends JFrame {
	
	public Menu() {
		
		setTitle("Base de Datos FilmotecaII");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);		
		
		JButton btnInsertarDirector = new JButton("Insertar Director");
		btnInsertarDirector.addActionListener(new BtnInsertarDirectorActionListener());
		btnInsertarDirector.setBounds(150, 50, 200, 30);
		getContentPane().add(btnInsertarDirector);
		
		JButton btnModificarDirector = new JButton("Modificar Director");
		btnModificarDirector.addActionListener(new BtnModificarDirectorActionListener());
		btnModificarDirector.setBounds(150, 100, 200, 30);
		getContentPane().add(btnModificarDirector);
		
		JButton btnEliminarDirector = new JButton("Eliminar Director");
		btnEliminarDirector.addActionListener(new BtnEliminarDirectorActionListener());
		btnEliminarDirector.setBounds(150, 150, 200, 30);
		getContentPane().add(btnEliminarDirector);
		
		JButton btnInsertarPelicula = new JButton("Insertar Pelicula");
		btnInsertarPelicula.addActionListener(new BtnInsertarPeliculaActionListener());
		btnInsertarPelicula.setBounds(150, 200, 200, 30);
		getContentPane().add(btnInsertarPelicula);
		
		JButton btnModificarPelicula = new JButton("Modificar Pelicula");
		btnModificarPelicula.addActionListener(new BtnModificarPeliculaActionListener());
		btnModificarPelicula.setBounds(150, 250, 200, 30);
		getContentPane().add(btnModificarPelicula);
		
		JButton btnEliminarPelcula = new JButton("Eliminar Pelicula");
		btnEliminarPelcula.addActionListener(new BtnEliminarPeliculaActionListener());
		btnEliminarPelcula.setBounds(150, 300, 200, 30);
		getContentPane().add(btnEliminarPelcula);
		
		JButton btnListados = new JButton("Listados");
		btnListados.addActionListener(new BtnListadosActionListener());
		btnListados.setBounds(150, 350, 200, 30);
		getContentPane().add(btnListados);
		
		setVisible(true);
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}
	
	private class BtnInsertarDirectorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new InsertarDirector();
		}
	}
	
	private class BtnModificarDirectorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new ModificarDirector();
		}
	}
	
	private class BtnEliminarDirectorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new EliminarDirector();
		}
	}
	
	private class BtnInsertarPeliculaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new InsertarPelicula();
		}
	}
	
	private class BtnModificarPeliculaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new ModificarPelicula();
		}
	}
	
	private class BtnEliminarPeliculaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new EliminarPelicula();
		}
	}
	
	private class BtnListadosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new FiltrarPeliculas();
		}
	}
}


