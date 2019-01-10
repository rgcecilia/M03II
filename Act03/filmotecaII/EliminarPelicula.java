package filmotecaII;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class EliminarPelicula extends JFrame {

	private JComboBox peliculas;
	private JButton eliminar;
	private JButton volver;
	ArrayList<Pelicula> listaPeliculas = Main.bbdd.listaPeliculas();
	ArrayList<Director> listaDirectores = Main.bbdd.listarDirector();
	String [] arrayPeliculas = new String [listaPeliculas.size()];
	int [] arrayIds = new int [listaPeliculas.size()];
	
	public EliminarPelicula(){
		
		setTitle("Eliminar Pelicula");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);			
		
		for( int i = 0; i < listaPeliculas.size(); i++ ) {
			arrayPeliculas[i] = listaPeliculas.get(i).toString();
			arrayIds[i] = listaPeliculas.get(i).getId();
		}
		
		peliculas = new JComboBox();
		peliculas.setModel(new DefaultComboBoxModel(arrayPeliculas));
		peliculas.setSelectedItem(null);
		peliculas.setBounds(100, 50, 200, 25);
		getContentPane().add(peliculas);
		
		eliminar = new JButton("Eliminar seleccionada");
		eliminar.addActionListener(new eliminarPelicula());
		eliminar.setBounds(100, 100, 200, 30);
		getContentPane().add(eliminar);
		
		volver = new JButton("Volver a Inicio");
		volver.addActionListener(new volverInicio());
		volver.setBounds(100, 150, 200, 30);
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
	
	private class eliminarPelicula implements ActionListener {
		public void actionPerformed(ActionEvent arg) {
			
			if(peliculas.getSelectedItem()==null) {
				JOptionPane.showMessageDialog(null, "Debes Seleccionar una Pelicula");
			}else{
				int pos = (int)peliculas.getSelectedIndex();
				int idSeleccionado = arrayIds[pos];						
					try {
						Main.bbdd.eliminarPelicula(idSeleccionado);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Pelicula Eliminada!");	
					new EliminarPelicula();
					dispose();
				}
			}
	}		
		
}
