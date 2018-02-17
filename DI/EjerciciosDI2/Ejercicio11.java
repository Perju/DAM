package EjerciciosDI2;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejercicio11 extends JFrame {

	public Ejercicio11() {
		super("Ejemplo de dibujo");
		
		// añadimos un JPanel
		add(new JPanel() {
			//sobre escribimos el metodo
			public void paintComponent(Graphics g) {
				g.drawString("Interfaz Grafica", 40, 40);
			}
		});// fin add()
		
		// configuraciones del Frame principal
		setSize(200,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ejercicio11 app = new Ejercicio11();
	}
}