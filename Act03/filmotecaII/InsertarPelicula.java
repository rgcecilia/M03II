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
public class InsertarPelicula extends JFrame {

	private JTextField nombre;
	private JComboBox directores;
	private JTextField pais;
	private JTextField duracion;
	private JTextField genero;
	private JButton insertar;
	private JButton volver;
	ArrayList<Director> listaDirectores = Main.bbdd.listarDirector();
	String [] arrayDirectores = new String [listaDirectores.size()];
	int [] arrayIds = new int [listaDirectores.size()];
	
	public InsertarPelicula(){
		
		setTitle("Crear Pelicula");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);			
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(50, 20, 100, 25);
		getContentPane().add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(150, 20, 200, 25);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		for( int i = 0; i < listaDirectores.size(); i++ ) {
			arrayDirectores[i] = listaDirectores.get(i).toString();
			arrayIds[i] = listaDirectores.get(i).getId();
		}
		
		JLabel lblDirector = new JLabel("Director: ");
		lblDirector.setBounds(50, 50, 100, 25);
		getContentPane().add(lblDirector);
		
		directores = new JComboBox();
		directores.setModel(new DefaultComboBoxModel(arrayDirectores));
		directores.setSelectedItem(null);
		directores.setBounds(150, 50, 200, 25);
		getContentPane().add(directores);
		
		JLabel lblPais = new JLabel("Pais: ");
		lblPais.setBounds(50, 80, 100, 25);
		getContentPane().add(lblPais);
		
		pais = new JTextField();
		pais.setBounds(150, 80, 200, 25);
		getContentPane().add(pais);
		pais.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion: ");
		lblDuracion.setBounds(50, 110, 100, 25);
		getContentPane().add(lblDuracion);
		
		duracion = new JTextField();
		duracion.setBounds(150, 110, 200, 25);
		getContentPane().add(duracion);
		duracion.setColumns(10);
		
		JLabel lblGenero= new JLabel("Genero: ");
		lblGenero.setBounds(50, 140, 100, 25);
		getContentPane().add(lblGenero);
		
		genero = new JTextField();
		genero.setBounds(150, 140, 200, 25);
		getContentPane().add(genero);
		genero.setColumns(10);
		
		insertar = new JButton("Crear");
		insertar.addActionListener(new crearPelicula());
		insertar.setBounds(100, 180, 200, 30);
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
	
	private class crearPelicula implements ActionListener {
		public void actionPerformed(ActionEvent arg) {
			
			if(directores.getSelectedItem()==null) {
				JOptionPane.showMessageDialog(null,"La pelicula debe tener un director");	
			}else{
			String nombreN = nombre.getText();
			int pos = directores.getSelectedIndex();
			int idDirector = arrayIds[pos];	
			String paisN = pais.getText();
			String duracionN = duracion.getText();
			String generoN = genero.getText();
			
				if(nombreN.equals("") || paisN.equals("") || duracionN.equals("") || generoN.equals("") ) {	
					JOptionPane.showMessageDialog(null, "Debes rellenar todos los datos");	
				}else{			
					try {
						Main.bbdd.crearPelicula(nombreN,idDirector,paisN,duracionN,generoN);
					}catch (Exception e){
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Pelicula Creada!");	
				}
			}
		}		
	}	
}
