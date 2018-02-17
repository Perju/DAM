package EjerciciosDI2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ejercicio17 extends JFrame implements ActionListener {
	
	private JTextField cantidad;
	private JButton btnEuros, btnPesetas;
	
	public Ejercicio17() {
		super("Conversor Euros-Pesetas");
		// creamos los elementos necesarios
		btnEuros = new JButton("A euros");
		btnPesetas = new JButton("A pesetas");
		cantidad = new JTextField(10);
		// las imagenes estan en un directorio incluidgo en .gitignore y no se
		// actualizan en el repositorio. Para evitar errores, añadir las vuestras
		// en la ruta relativa a la capeta raiz del proyecto, "resocurces/DI".
		JLabel imgPeseta = new JLabel(
				new ImageIcon("resources/DI/spaincoin.png"));
		JLabel imgEuro = new JLabel(
				new ImageIcon("resources/DI/euro.png"));
		// los añadimos al JFrame
		add(imgEuro); add(btnEuros);
		add(cantidad);
		add(imgPeseta); add(btnPesetas);
		// añadimos el listener a los botones
		btnEuros.addActionListener(this);
		btnPesetas.addActionListener(this);
		// configuramos el JFrame
		setLayout(new FlowLayout());
		setSize(300,250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		Ejercicio17 app = new Ejercicio17();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		float valor = Float.parseFloat(cantidad.getText());
		if(event.getActionCommand().toString()=="A euros") {
			// 166.321 => dobule, 166.321f => float
			valor = valor / 166.321f;
		}else if(event.getActionCommand().toString()=="A pesetas") {
			valor = valor * 166.321f;
		}
		cantidad.setText(Float.toString(valor));
	}
	
}
