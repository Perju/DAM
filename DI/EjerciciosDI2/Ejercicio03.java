package EjerciciosDI2;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejercicio03 extends JFrame {
	// declaramos los componentes necesarios
	private Container panel;
	private JButton miboton;
	
	public Ejercicio03() {
		super("Ejemplo 03 - botón");
		// La String del construtor es el texto a mostrar
		miboton = new JButton("Aceptar");
		// obtenemos el contentPane de nuestra clase
		panel = getContentPane();
		// añadimos el boton al panel
		panel.add(miboton);
		// configuramos nuestra clase
		setSize(200, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ejercicio03 app = new Ejercicio03();
	}
}