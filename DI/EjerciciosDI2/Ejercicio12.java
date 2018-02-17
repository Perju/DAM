package EjerciciosDI2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejercicio12 extends JFrame {

	public Ejercicio12() {
		super("Ejemplo dibujo");
		add(new MiPanel());
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		Ejercicio12 app = new Ejercicio12();
	}
	
	// Una clase privada para el panel de dibujo que cuando se vuelva 
	// mas compleja, la moveremos a su propio fichero.java
	private class MiPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Color c = new Color(180,10,120);
			g.setColor(c);
			g.drawString("Dibujar en el panel", 90, 90);
			g.fillOval(1, 1, 90, 90);
		}
	}
}
