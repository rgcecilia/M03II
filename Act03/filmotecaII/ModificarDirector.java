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
public class ModificarDirector extends JFrame{
	
	private JComboBox directores;
	private JTextField nombre;
	private JButton modificar;
	private JButton volver;
	ArrayList<Director> listaDirectores = Main.bbdd.listarDirector();
	String [] arrayDirectores = new String [listaDirectores.size()];
	int [] arrayIds = new int [listaDirectores.size()];
	
	public ModificarDirector(){
		
		setTitle("Editar Director");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);			
		
		for( int i = 0; i < listaDirectores.size(); i++ ) {
			arrayDirectores[i] = listaDirectores.get(i).toString();
			arrayIds[i] = listaDirectores.get(i).getId();
		}
		
		JLabel lblSeleccion = new JLabel("Seleccion: ");
		lblSeleccion.setBounds(50, 20, 100, 25);
		getContentPane().add(lblSeleccion);
		
		directores = new JComboBox();
		directores.setModel(new DefaultComboBoxModel(arrayDirectores));
		directores.setSelectedItem(null);
		directores.setBounds(150, 20, 200, 25);
		getContentPane().add(directores);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(50, 60, 100, 25);
		getContentPane().add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(150, 60, 200, 25);
		getContentPane().add(nombre);
		nombre.setColumns(10);
				
		modificar = new JButton("Modificar");
		modificar.addActionListener(new modificarDirector());
		modificar.setBounds(100, 100, 200, 30);
		getContentPane().add(modificar);
		
		volver = new JButton("Volver a Inicio");
		volver.addActionListener(new volverInicio());
		volver.setBounds(100, 140, 200, 30);
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
	
	private class modificarDirector implements ActionListener {
		public void actionPerformed(ActionEvent arg) {
			
			if(directores.getSelectedItem()==null) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar un director");	
				new ModificarDirector();
				dispose();
			}else{	
				int pos = (int)directores.getSelectedIndex();
				int idSeleccionado = arrayIds[pos];	
				String nombreDirector = nombre.getText();
			if(nombreDirector.equals("")) {	
				JOptionPane.showMessageDialog(null, "No puedes dejar campos vacios");	
			}else{			
				try {
					Main.bbdd.modificarDirector(idSeleccionado,nombreDirector);
				} catch (Exception e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Director Modificado");	
				new ModificarDirector();
				dispose();
			}
			}
		}		
	}	
}
