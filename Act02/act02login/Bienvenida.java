package act02login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */
public class Bienvenida extends JFrame {
	
	private Login name;
	
	public Bienvenida(Login name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.name = name;
		getContentPane().setLayout(null);
		
		
		String mensaje = "Bienvenido " + this.name.getUser().getText();
		
		JLabel lblBienvenido = new JLabel(mensaje);
		lblBienvenido.setBounds(100, 50, 100, 25);
		getContentPane().add(lblBienvenido);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new BtnCerrarActionListener());
		btnCerrar.setBounds(100, 100, 100, 25);
		getContentPane().add(btnCerrar);
		
		setSize(300, 200);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
	}
	
	private class BtnCerrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}
