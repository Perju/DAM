package dni;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		String dni;
		boolean salir=false;
		do{
			// pedimos datos dentro de un bucle infinito del que no podemos salir
			System.out.println("Introduce un DNI o s para salir");
			dni=kb.nextLine();
			// capturamos nuestro propio error
			if(dni.toLowerCase().equals("s")) {
				salir=true;
			}else {
				try{
					DNI.comporbarDNI(dni);
				}catch(DNIException e){
					e.printStackTrace();
				}	
			}
		}while(!salir);
		kb.close();
	}
}