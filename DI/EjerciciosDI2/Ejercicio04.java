package EjerciciosDI2;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejercicio04 extends JFrame {
	
	private JButton miboton;
	
	public Ejercicio04() {
		super("Ejemplo04 - botón");
		// crear y añadir boton la IU de mi clase
		miboton = new JButton("Aceptar");
		add(miboton);
		// configurar tamaño y demas
		setSize(200, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ejercicio04 app = new Ejercicio04();
	}
}