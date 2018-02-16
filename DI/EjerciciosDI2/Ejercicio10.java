package EjerciciosDI2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ejercicio10 extends JFrame {
	
	public Ejercicio10() {
		super("Horno microondas");
		// tambien se puede cambiar el titulo mas tarde con
		// setTitle("Horno microondas");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		// creamos un panel para los botones usando un GridLayout
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 3));
		// Añadimos los botones al panel
		for( int i = 1; i <= 10; i++ ) {
			p1.add(new JButton("" +(i%10)));
		}
		p1.add(new JButton("Start"));
		p1.add(new JButton("Stop"));
		// creamos un segundo panel para un campo de texto y el panel p1
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(new JTextField("Aquí el tiempo"), BorderLayout.NORTH);
		p2.add(p1, BorderLayout.CENTER);
		
		// añadimos el panel 2 y un boton nuevo al marco principal
		add(p2, BorderLayout.EAST);
		add(new JButton("Aquí la comida"), BorderLayout.CENTER);
		
		setSize(400, 250);
		setVisible(true);
	}

	public static void main(String[] args) {
		Ejercicio10 app = new Ejercicio10();
	}
}
