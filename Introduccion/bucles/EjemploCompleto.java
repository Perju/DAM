package bucles;

public class EjemploCompleto {

	public static void main(String[] args) {
		// int i=0 variable para controlar el comportamiento del bucle
		// i<10 condicion sobre la variable i para realizar una iteracion
		// i++ calculo de un nuevo valor de i con postincremento
		for( int i=0 ; i<10 ; i++ ) {
			System.out.println("Valor de i: "+i);
		}
		
		// para hacer un bucle como el anterior voy a declarar una variable i
		int i = 0;
		// entre los parentesis indico la condicion
		while(i<10) {
			System.out.println("Valor de i: "+i);
			// y tengo que añadir dentro del bucle el calculo del nuevo valor de i
			// puede ser en cualquier parte, pero por hacerlo igual que el bucle for
			// lo añado al final del bucle while
			i++;
		}
		
		// voy a hacer el mismo bucle con do while, pero sin cambiar el valor de i
		// que seguira valiendo 10 y el bucle se ejecuta una sola vez.
		do {
			System.out.println("Valor de i: "+1);
			// despues de ejecutar la primera iteracion de comprueba la condicion
		}while(i<10);
	}
}
