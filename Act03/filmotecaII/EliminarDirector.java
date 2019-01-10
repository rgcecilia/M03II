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
public class EliminarDirector extends JFrame {

	private JComboBox directores;
	private JButton eliminar;
	private JButton volver;
	ArrayList<Pelicula> listaPeliculas = Main.bbdd.listaPeliculas();
	ArrayList<Director> listaDirectores = Main.bbdd.listarDirector();
	String [] arrayDirectores = new String [listaDirectores.size()];
	int [] arrayIds = new int [listaDirectores.size()];
	
	public EliminarDirector(){
		
		setTitle("Eliminar directores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);			
		
		for( int i = 0; i < listaDirectores.size(); i++ ) {
			arrayDirectores[i] = listaDirectores.get(i).toString();
			arrayIds[i] = listaDirectores.get(i).getId();
		}
		
		directores = new JComboBox();
		directores.setModel(new DefaultComboBoxModel(arrayDirectores));
		directores.setSelectedItem(null);
		directores.setBounds(100, 50, 200, 30);
		getContentPane().add(directores);
		
		eliminar = new JButton("Eliminar seleccionado");
		eliminar.addActionListener(new eliminarDirector());
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
	
	private class eliminarDirector implements ActionListener {
		public void actionPerformed(ActionEvent arg) {
			if(directores.getSelectedItem()== null) {
				JOptionPane.showMessageDialog(null,"Debes seleccionar un director para eiminarlo");
				new EliminarDirector();
				dispose();
			}else{
			int pos = (int)directores.getSelectedIndex();
			int idSeleccionado = arrayIds[pos];	
			if(buscarDirector(idSeleccionado)) {
				JOptionPane.showMessageDialog(null, "Este director dispone de peliculas, no puede eliminarse");
			}else{			
				try {
					Main.bbdd.eliminarDirector(idSeleccionado);
				} catch (Exception e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Director Eliminado!");	
				new EliminarDirector();
				dispose();
			}
			}
		}		
	}
	
	public boolean buscarDirector(int id) {
		for (int i = 0 ; i < (listaPeliculas.size()); i++ ) {
			if(listaPeliculas.get(i).getDirector() == id) {
				return true;
			}		
		}
		return false;
	}
	
}
