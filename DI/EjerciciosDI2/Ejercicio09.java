package EjerciciosDI2;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejercicio09 extends JFrame {

	public Ejercicio09() {
		super("Ejemplo de Layout");
		// un gridLayout de 4x3 y 5px de margenes
		setLayout(new GridLayout(4, 3, 5, 5));
		// añadimos botones
		for(int i = 1; i<=10; i++) {
			add(new JButton(""+i));
		}
		
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ejercicio09 app = new Ejercicio09();
	}
}
