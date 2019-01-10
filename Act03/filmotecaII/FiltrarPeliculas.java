package filmotecaII;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class FiltrarPeliculas extends JFrame{
	
	private JComboBox genero;
	private JComboBox directores;
	private JButton filtrar;
	private JButton volver;
		
	ArrayList<Director> listaDirectores = Main.bbdd.listarDirector();
	String [] arrayDirectores = new String [listaDirectores.size()];
	int [] arrayIds = new int [listaDirectores.size()];
	
	ArrayList<Genero> listaGeneros = Main.bbdd.listarGeneros();	
	String [] arrayGeneros = new String [listaGeneros.size()];
	
	ArrayList<Pelicula> misPeliculas = Main.bbdd.listaPeliculas();
	
	public FiltrarPeliculas(){
			
		setTitle("Filtrar Peliculas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);			
		
		for( int i = 0; i < listaDirectores.size(); i++ ) {
			arrayDirectores[i] = listaDirectores.get(i).toString();
			arrayIds[i] = listaDirectores.get(i).getId();
		}
		
		directores = new JComboBox();
		directores.setModel(new DefaultComboBoxModel(arrayDirectores));
		directores.setSelectedItem(null);
		directores.setBounds(100, 50, 200, 25);
		getContentPane().add(directores);
		
		for( int i = 0; i < listaGeneros.size(); i++ ) {
			arrayGeneros[i] = listaGeneros.get(i).toString();
		}
		
		genero = new JComboBox();
		genero.setModel(new DefaultComboBoxModel(arrayGeneros));
		genero.setSelectedItem(null);
		genero.setBounds(100, 100, 200, 25);
		getContentPane().add(genero);
		
		filtrar = new JButton("Filtrar");
		filtrar.addActionListener(new filtrarPeliculas());
		filtrar.setBounds(100, 150, 200, 30);
		getContentPane().add(filtrar);
		
		volver = new JButton("Volver a Inicio");
		volver.addActionListener(new volverInicio());
		volver.setBounds(100, 200, 200, 30);
		getContentPane().add(volver);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(400, 300);	
		setLocationRelativeTo(null);

	}
	
	private class volverInicio implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			Menu miMenu = new Menu();
		}		
	}
	
	private class filtrarPeliculas implements ActionListener {
		String directorSeleccionado = "";
		String generoSeleccionado = "";
		public void actionPerformed(ActionEvent e) {
			if(directores.getSelectedItem()== null && genero.getSelectedItem()==null) {
				dispose();
				new MostrarPeliculas(misPeliculas);
			}else{
				if(directores.getSelectedItem()!= null) {
					directorSeleccionado=directores.getSelectedItem().toString();
				}
				if(genero.getSelectedItem()!= null) {		
					generoSeleccionado=genero.getSelectedItem().toString();
				}
				misPeliculas = Main.bbdd.listaPeliculas(directorSeleccionado, generoSeleccionado);
				dispose();
				new MostrarPeliculas(misPeliculas);
			}
		}		
	}
		
}
