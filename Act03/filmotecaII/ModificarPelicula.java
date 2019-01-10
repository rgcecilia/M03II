package filmotecaII;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class ModificarPelicula extends JFrame{
	
	private JComboBox pelicula;
	private JTextField nombre;
	private JComboBox directores;
	private JTextField pais;
	private JTextField duracion;
	private JTextField genero;
	private JButton insertar;
	private JButton volver;
	ArrayList<Director> listaDirectores = Main.bbdd.listarDirector();
	ArrayList<Pelicula> listaPeliculas = Main.bbdd.listaPeliculas();
	String [] arrayDirectores = new String [listaDirectores.size()];
	String [] arrayPeliculas = new String [listaPeliculas.size()];
	int [] arrayIdsDir = new int [listaDirectores.size()];
	int [] arrayIdsPel = new int [listaPeliculas.size()];
	
	public ModificarPelicula(){
		
		setTitle("Modificar Pelicula");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		

		for( int i = 0; i < listaPeliculas.size(); i++ ) {
			arrayPeliculas[i] = listaPeliculas.get(i).toString();
			arrayIdsPel[i] = listaPeliculas.get(i).getId();
		}
		
		JLabel lblPelicula = new JLabel("Seleccione: ");
		lblPelicula.setBounds(50, 10, 100, 25);
		getContentPane().add(lblPelicula);
		
		pelicula = new JComboBox();
		pelicula.setModel(new DefaultComboBoxModel(arrayPeliculas));
		pelicula.setSelectedItem(null);
		pelicula.setBounds(150, 10, 200, 25);
		getContentPane().add(pelicula);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(50, 40, 100, 25);
		getContentPane().add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(150, 40, 200, 25);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		for( int i = 0; i < listaDirectores.size(); i++ ) {
			arrayDirectores[i] = listaDirectores.get(i).toString();
			arrayIdsDir[i] = listaDirectores.get(i).getId();
		}
		
		JLabel lblDirector = new JLabel("Director: ");
		lblDirector.setBounds(50, 70, 100, 25);
		getContentPane().add(lblDirector);
		
		directores = new JComboBox();
		directores.setModel(new DefaultComboBoxModel(arrayDirectores));
		directores.setSelectedItem(null);
		directores.setBounds(150, 70, 200, 25);
		getContentPane().add(directores);
		
		JLabel lblPais = new JLabel("Pais: ");
		lblPais.setBounds(50, 100, 100, 25);
		getContentPane().add(lblPais);
		
		pais = new JTextField();
		pais.setBounds(150, 100, 200, 25);
		getContentPane().add(pais);
		pais.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion: ");
		lblDuracion.setBounds(50, 130, 100, 25);
		getContentPane().add(lblDuracion);
		
		duracion = new JTextField();
		duracion.setBounds(150, 130, 200, 25);
		getContentPane().add(duracion);
		duracion.setColumns(10);
		
		JLabel lblGenero= new JLabel("Genero: ");
		lblGenero.setBounds(50, 160, 100, 25);
		getContentPane().add(lblGenero);
		
		genero = new JTextField();
		genero.setBounds(150, 160, 200, 25);
		getContentPane().add(genero);
		genero.setColumns(10);
		
		insertar = new JButton("Modificar");
		insertar.addActionListener(new modificarPelicula());
		insertar.setBounds(100, 190, 200, 30);
		getContentPane().add(insertar);
		
		volver = new JButton("Volver a Inicio");
		volver.addActionListener(new volverInicio());
		volver.setBounds(100, 220, 200, 30);
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
	
	private class modificarPelicula implements ActionListener {
		public void actionPerformed(ActionEvent arg) {
			
			if(pelicula.getSelectedItem()==null) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar una pelicula para modificar");
				dispose();
				new ModificarPelicula();
			}else{
				if(directores.getSelectedItem()==null) {
					JOptionPane.showMessageDialog(null,"La pelicula debe tener un director");	
				}else{
					int pel = pelicula.getSelectedIndex();
					int id = arrayIdsPel[pel];	
					String nombreN = nombre.getText();
					int pos = directores.getSelectedIndex();
					int idDirector = arrayIdsDir[pos];
					String paisN = pais.getText();
					String duracionN = duracion.getText();
					String generoN = genero.getText();
			
					if(pelicula.equals(null) || nombreN.equals("") || paisN.equals("") || duracionN.equals("") || generoN.equals("") ) {	
						JOptionPane.showMessageDialog(null, "Debes Rellenar todos los datos");
						new ModificarPelicula();
						dispose();
					}else{			
						try {
							Main.bbdd.modificarPelicula(id,nombreN,idDirector,paisN,duracionN,generoN);
						} catch (Exception e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Pelicula Modificada!");
						new ModificarPelicula();
						dispose();
					}
				}	
			}
		}
	}
}
