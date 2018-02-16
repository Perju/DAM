package EjerciciosDI2;

import javax.swing.JFrame;

public class Ejercicio01 extends JFrame {

	public Ejercicio01() {
		// le pasamos al constructor de la clase padre una cadena
		// para que le ponga un titulo a la ventana
		super("Ejemplo 01");
		// la hacemos visible
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ejercicio01 app = new Ejercicio01();
	}
}