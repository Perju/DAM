package EjerciciosDI2;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejercicio06 {
	
	private JButton miboton;

	public Ejercicio06() {
		JFrame frame = new JFrame("Ejemplo 06");
		
		miboton = new JButton("Aceptar");
		frame.add(miboton);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ejercicio06 app = new Ejercicio06();
	}
}