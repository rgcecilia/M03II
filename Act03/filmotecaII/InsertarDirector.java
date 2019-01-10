package filmotecaII;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class InsertarDirector extends JFrame {

	private JTextField nombre;
	private JButton insertar;
	private JButton volver;
	
	public InsertarDirector(){
		
		setTitle("Crear Director");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);			
				
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(50, 50, 100, 25);
		getContentPane().add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(150, 50, 200, 25);
		getContentPane().add(nombre);
		nombre.setColumns(10);
				
		insertar = new JButton("Crear");
		insertar.addActionListener(new crearDirector());
		insertar.setBounds(100, 100, 200, 30);
		getContentPane().add(insertar);
		
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
	
	private class crearDirector implements ActionListener {
		public void actionPerformed(ActionEvent arg) {
			String nombreDirector = nombre.getText();
			if(nombreDirector.equals("")) {	
				JOptionPane.showMessageDialog(null, "Debes Rellenar el Nombre ");	
			}else{			
				try {
					Main.bbdd.crearDirector(nombreDirector);
				} catch (Exception e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Director Creado");
				new InsertarDirector();
				dispose();
			}
		}		
	}	
}
