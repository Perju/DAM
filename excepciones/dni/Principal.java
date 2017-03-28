package dni;

import java.util.Scanner;

public class Principal {
	public static void comporbarDNI(String dni) throws DNIFormatoCadenaIncorrecto{
		//aprovechar la captura de excepciones para lanzar la mia propia
		try{
			//si la longitud del DNI no es correcta osea 9 generamos un error
			if(dni.length()!=9){Integer.parseInt("a");}
			// intentamos convertir los 8 primero caracteres a numeros y si no son numeros se genera el error solo
			Integer.parseInt(dni.substring(0, 7));
			if((dni.charAt(8)>'z' || dni.charAt(8)<'a') && (dni.charAt(8)>'Z' || dni.charAt(8)<'A')){
				Integer.parseInt("a");//si no termina en una letra generamos un error
			}
		}catch(Exception e){
			// le pasamos una cadena al constructor de la Excepcion
			throw new DNIFormatoCadenaIncorrecto("formato incorrecto de la cadena");
		}
	}

	public static void main(String[] args) {
		System.out.println("Dame un dni");
		String dni;
		boolean salir=false;
		do{
			Scanner kb = new Scanner(System.in);
			dni=kb.nextLine();
			try{
				comporbarDNI(dni);
			}catch(DNIFormatoCadenaIncorrecto e){
				e.printStackTrace();
			}
		}while(!salir);
	}
}
