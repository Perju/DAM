package EjerciciosDI2;

import javax.swing.JFrame;

public class Ejercicio02 {

	public Ejercicio02() {
		// en vez de heredar de JFrame creamos un objeto 
		JFrame frame = new JFrame("Ejemplo 02");
		// enpaquetamos el frame "empaquetar graficamente"
		frame.pack();
		
		frame.setVisible(true);
		// tenemos que hacer referencia a JFrame para poder usar
		// las constantes de la clase
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public static void main(String[] args) {
		Ejercicio02 app = new Ejercicio02();
	}
}