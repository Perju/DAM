package EjerciciosDI2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ejercicio14 extends JFrame implements ActionListener{
	
	JButton botonCopiar;
	JTextField campoValor, resultado;
	
	public Ejercicio14() {
		setLayout(new FlowLayout());
		
		// Instanciamos los objetos necesarios
		campoValor = new JTextField(5);
		botonCopiar = new JButton("Copiar");
		resultado = new JTextField(5);
		// Añadimos nuestra clase oyente al boton
		botonCopiar.addActionListener(this);
		
		// Añadimos los objetos y alguno anonimo
		// al Frame principal
		add(new JLabel("Valor "));// JLabel anónimo
		add(campoValor);		
		add(botonCopiar);
		add(new JLabel("Copia "));
		add(resultado);
		
		// configuramos el Frame principal
		setSize(400,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Ejercicio14 app = new Ejercicio14();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		resultado.setText(campoValor.getText());
	}
}