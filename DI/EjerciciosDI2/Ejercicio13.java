package EjerciciosDI2;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejercicio13 extends JFrame implements ActionListener {

	JButton boton;
	
	public Ejercicio13() {
		boton = new JButton("¡Pulsa!");
		add(boton);
		boton.addActionListener(this);
		setSize(100,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ejercicio13 app = new Ejercicio13();
	}
	
	// la propia interfaz implementa ActionListener para
	// poder ser una clase oyente "para los eventos"
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Toolkit.getDefaultToolkit().beep();
	}
}