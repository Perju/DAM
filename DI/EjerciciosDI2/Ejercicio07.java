package EjerciciosDI2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejercicio07 extends JFrame {

	public Ejercicio07() {
		super("Ejemplo de layout");
		// congiuramos el panel
		setSize(500, 250);
		// configuramos un FlowLayout con margenes entre los elementos
		// 10px de margen horizontal y 20px de margen vertical
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		// añadimos los botones
		for(int i = 1; i <= 10; i++) {
			add(new JButton("Componente "+i));
		}
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ejercicio07 app = new Ejercicio07();
	}

}
