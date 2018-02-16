package EjerciciosDI2;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejercicio08 extends JFrame {
	
	public Ejercicio08() {
		super("Ejemplo de layout");
		// configuramos un border layout
		setLayout(new BorderLayout(5, 10));
		// rellamos el layout con botones
		add(new JButton("1"), BorderLayout.EAST);
		add(new JButton("2"), BorderLayout.SOUTH);
		add(new JButton("3"), BorderLayout.WEST);
		add(new JButton("4"), BorderLayout.NORTH);
		add(new JButton("5"), BorderLayout.CENTER);
		
		setSize(100,150);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Ejercicio08 app = new Ejercicio08();
	}
}