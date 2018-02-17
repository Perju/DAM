package EjerciciosDI2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ejercicio15 extends JFrame implements ActionListener {
	
	private int contador;
	private JButton boton;
	private JLabel label;
	
	public Ejercicio15() {
		// iniciamos el valor del contador
		contador = 0;
		// creamos los objetos de la interfaz
		boton = new JButton("Pulsa");
		label = new JLabel("Pulsaciones: 0");
		// los añadimos al JFrame principal
		add(boton);
		add(label);
		// establecemos el Layout del JFrame
		setLayout(new FlowLayout());
		// añadimos el listener al boton
		boton.addActionListener(this);
		// terminamo de configurar el JFrame
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		Ejercicio15 app = new Ejercicio15();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// comprobacion para usar el Listener con mas de un boton
		if(e.getSource()==boton) {
			// uso del operador de preincremento para actualizar
			// la variable antes de concatenarla
			label.setText("Pulsaciones: " + (++contador));
		}
	}
}
