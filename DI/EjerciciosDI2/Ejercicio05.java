package EjerciciosDI2;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejercicio05 {
	
	private JButton miboton;
	private Container panel;

	public Ejercicio05() {
		// creamos un nuevo frame y 
		// obtenemos su panel de contenido
		JFrame frame = new JFrame("Ejemplo05");
		panel = frame.getContentPane();
		
		miboton = new JButton("Aceptar");
		panel.add(miboton);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ejercicio05 app = new Ejercicio05();
	}
}