
package filmotecaII;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M0
 */
public class MostrarPeliculas extends JFrame{

	private ArrayList<Pelicula> misPeliculas;
	private JTextField titulo;
	private JTextField director;
	private JTextField pais;
	private JTextField duracion;
	private JTextField genero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnVolver;
	
	ArrayList<Director> listaDirectores = Main.bbdd.listarDirector();
	String [] arrayDirectores = new String [listaDirectores.size()];
	int [] arrayIds = new int [listaDirectores.size()];
	
	private int pos = 0;
	
	public MostrarPeliculas(ArrayList<Pelicula> misPeliculasFiltradas) {
		
		misPeliculas = misPeliculasFiltradas;
		
		setTitle("Datos de la pelicula");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo: ");
		lblTitulo.setBounds(50, 20, 100, 25);
		getContentPane().add(lblTitulo);
		
		titulo = new JTextField();
		titulo.setBounds(150, 20, 200, 25);
		titulo.setEditable(false);
		getContentPane().add(titulo);
		titulo.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director: ");
		lblDirector.setBounds(50, 60, 100, 25);
		getContentPane().add(lblDirector);
		
		director = new JTextField();
		director.setBounds(150, 60, 200, 25);
		director.setEditable(false);
		getContentPane().add(director);
		director.setColumns(10);
		
		JLabel lblPais = new JLabel("Pais: ");
		lblPais.setBounds(50, 100, 100, 25);
		getContentPane().add(lblPais);
		
		pais = new JTextField();
		pais.setBounds(150, 95, 200, 25);
		pais.setEditable(false);
		getContentPane().add(pais);
		pais.setColumns(30);
		
		JLabel lblDuracion = new JLabel("duracion: ");
		lblDuracion.setBounds(50, 130, 100, 25);
		getContentPane().add(lblDuracion);
		
		duracion = new JTextField();
		duracion.setBounds(150, 130, 200, 25);
		duracion.setEditable(false);
		getContentPane().add(duracion);
		duracion.setColumns(10);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(50, 165, 100, 25);
		getContentPane().add(lblGenero);
		
		genero = new JTextField();
		genero.setBounds(150, 165, 200, 25);
		genero.setEditable(false);
		getContentPane().add(genero);
		genero.setColumns(10);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new btnAnterior());
		btnAnterior.setBounds(125, 220, 100, 25);
		getContentPane().add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new btnSiguiente());
		btnSiguiente.setBounds(225, 220, 100, 25);
		getContentPane().add(btnSiguiente);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new btnVolver());
		btnVolver.setBounds(175, 260, 100, 25);
		getContentPane().add(btnVolver);
		
		setVisible( true );
		setSize(450,350);
		setLocationRelativeTo(null);
		
		comprobarBotones();
		mostrarPelicula();
	}
	
	private void mostrarPelicula() {
		if(misPeliculas.size()==0) {
			JOptionPane.showMessageDialog(null,"No hay peliculas que mostrar");
			dispose();
			new FiltrarPeliculas();
		}else{
		titulo.setText(misPeliculas.get(pos).getTitulo());
		int id = misPeliculas.get(pos).getDirector();
		String dir ="";
		for(int i=0; i <(listaDirectores.size()); i++) {
			if(listaDirectores.get(i).getId() == id) {
				dir = listaDirectores.get(i).getNombre();
			}
		}
		director.setText(dir);
		pais.setText(misPeliculas.get(pos).getPais());
		duracion.setText(misPeliculas.get(pos).getDuracion());
		genero.setText(misPeliculas.get(pos).getGenero());
		}
	}
	
	private void comprobarBotones() {
		if(pos == 0) {
			btnAnterior.setVisible(false);
		} else {
			btnAnterior.setVisible(true);
		}
		if(pos == misPeliculas.size()-1) {
			btnSiguiente.setVisible( false );
		} else {
			btnSiguiente.setVisible(true);
		}
		
	}

	private class btnAnterior implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pos--;
			comprobarBotones();
			mostrarPelicula();
			
		}
	}
	
	private class btnSiguiente implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pos++;
			comprobarBotones();
			mostrarPelicula();
			
		}
	}
	
	private class btnVolver implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new FiltrarPeliculas();
			
		}
	}
}
