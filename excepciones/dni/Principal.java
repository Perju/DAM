package excepciones;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		String dni;
		boolean salir=false;
		do{
			// pedimos datos dentro de un bucle infinito del que no podemos salir
			Scanner kb = new Scanner(System.in);
			System.out.println("Dame un dni");
			dni=kb.nextLine();
			// capturamos nuestro propio error
			try{
				DNI.comporbarDNI(dni);
			}catch(DNIException e){
				e.printStackTrace();
			}
		}while(!salir);
	}
}