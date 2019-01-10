package act02InterfazGrafica;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class Ventana extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField apellido;
	@SuppressWarnings("rawtypes")
	private JComboBox edad;
	private JCheckBox cine;
	private JCheckBox deporte;
	private JCheckBox eventos;
	private JRadioButton masculino;
	private JRadioButton femenino;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Ventana() {
		
		setTitle("Datos del Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(50, 20, 100, 25);
		getContentPane().add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(150, 20, 200, 25);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(50, 60, 100, 25);
		getContentPane().add(lblApellido);
		
		apellido = new JTextField();
		apellido.setBounds(150, 60, 200, 25);
		getContentPane().add(apellido);
		apellido.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setBounds(50, 100, 100, 25);
		getContentPane().add(lblEdad);
		
		edad = new JComboBox();
		edad.setModel(new DefaultComboBoxModel(new String[] {"","10-15", "16-20", "21-25", "26-30", "31-40", "41-50","Mas de 50"}));
		edad.setBounds(150, 95, 200, 25);
		getContentPane().add(edad);
		
		JLabel lblNewLabel = new JLabel("Sexo: ");
		lblNewLabel.setBounds(50, 140, 50, 25);
		getContentPane().add(lblNewLabel);
		
		masculino = new JRadioButton("Masculino");
		masculino.setBounds(155, 140, 100, 25);
		getContentPane().add(masculino);
		
		femenino = new JRadioButton("Femenino");
		femenino.setBounds(255, 140, 140, 25);
		getContentPane().add(femenino);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(masculino);
		grupo.add(femenino);
		
		JLabel lblAficiones = new JLabel("Aficiones:");
		lblAficiones.setBounds(50, 180, 100, 25);
		getContentPane().add(lblAficiones);
		
		cine = new JCheckBox("Cine");
		cine.setBounds(150, 180, 50, 25);
		getContentPane().add(cine);
		
		deporte = new JCheckBox("Deporte");
		deporte.setBounds(205, 180, 70, 25);
		getContentPane().add(deporte);
		
		eventos = new JCheckBox("Eventos");
		eventos.setBounds(280, 180, 70, 25);
		getContentPane().add(eventos);
						
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new BotonAceptar());
		aceptar.setBounds(170, 250, 100, 25);
		getContentPane().add(aceptar);
		
		setVisible( true );
		setSize(450,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public JTextField getNombre() {
		return nombre;
	}
	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}
	public JTextField getApellido() {
		return apellido;
	}
	public void setApellido(JTextField apellido) {
		this.apellido = apellido;
	}
	
	private class BotonAceptar implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			String edadSeleccionada = (String) edad.getSelectedItem();
			Boolean Errores = false;
			
			
			if(nombre.getText().isEmpty()) {
				JOptionPane.showMessageDialog(Ventana.this, "Debes introducir tu nombre", "ERROR", JOptionPane.ERROR_MESSAGE);
				Errores = true;
			}
			if(apellido.getText().isEmpty()) {
				JOptionPane.showMessageDialog(Ventana.this, "Debes introducir tu apellido", "ERROR", JOptionPane.ERROR_MESSAGE);
				Errores = true;
			}
			if(edadSeleccionada == "") {
				JOptionPane.showMessageDialog(Ventana.this, "Debes introducir un rango de edad", "ERROR", JOptionPane.ERROR_MESSAGE);
				Errores = true;
			}
			if(!femenino.isSelected() && !masculino.isSelected() ) {
				JOptionPane.showMessageDialog(Ventana.this, "Debes seleccionar el sexo", "ERROR", JOptionPane.ERROR_MESSAGE );
				Errores = true;
			}
			if(!cine.isSelected() && !deporte.isSelected() && !eventos.isSelected()) {
				JOptionPane.showMessageDialog(Ventana.this, "Debes seleccionar al menos una aficion", "ERROR", JOptionPane.ERROR_MESSAGE );
				Errores = true;
			}	
			if(!Errores) {
				JOptionPane.showMessageDialog(Ventana.this, "Gracias por usar la aplicación", "CORRECTO", JOptionPane.INFORMATION_MESSAGE );
			
			}
		}
	}
}
