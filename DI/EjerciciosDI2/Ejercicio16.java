package EjerciciosDI2;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ejercicio16 extends JFrame implements ActionListener {

	JButton btnRojo = new JButton("Rojo");
	JButton btnAzul = new JButton("Azul");
	Container contenedor;
	
	public Ejercicio16() {
		super("Color de fondo");
		contenedor=this.getContentPane();
		setLayout(new FlowLayout());
		add(btnRojo);
		add(btnAzul);
		btnRojo.addActionListener(this);
		btnAzul.addActionListener(this);
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ejercicio16 app = new Ejercicio16();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRojo) {
			contenedor.setBackground(Color.RED);
		}else if(e.getSource()==btnAzul) {
			contenedor.setBackground(Color.BLUE);
		}
	}
}