package excepciones;

public class DNI{
	public static void comporbarDNI(String dni) throws DNIException{
		//aprovechar la captura de excepciones para lanzar la mia propia
		String error="";
		int numero=0,pos=0;
		try{
			
			//si la longitud del DNI no es correcta osea 9 generamos un error
			if(dni.length()!=9){
				error="DNI con logitud diferente a 9";
				Integer.parseInt("a");}
			// intentamos convertir los 8 primero caracteres a numeros y si no son numeros se genera el error solo
			error="DNI con error en el numero";
			numero=Integer.parseInt(dni.substring(0, 8));
			if((dni.charAt(8)>'z' || dni.charAt(8)<'a') && (dni.charAt(8)>'Z' || dni.charAt(8)<'A')){
				error="DNI caracter incorrecto para letra";
				Integer.parseInt("a");//si no termina en una letra generamos un error
			}
			char letras[]={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
			pos=numero%23;
			char letra=letras[numero%23];
			System.out.println("Letra "+letra+" posArray "+pos+" Numero "+numero);
			if(letra!=dni.toUpperCase().charAt(8)){
				error="letra incorrecta";
				Integer.parseInt("a");
			}
		}catch(Exception e){
			// le pasamos una cadena al constructor de la Excepcion
			throw new DNIException(error);
		}
	}
	
	//metodo que nos devuelve la letra que pertenece a un DNI o NIF tal como se crean en españa
	public static char obtenerLetra(String dni) throws DNIException {
        	//aprovechar la captura de excepciones para lanzar la mia propia
        	String error = "";
        	int numero = 0, pos = 0;
        	char letra;
        	try {
            	//si la longitud del DNI no es correcta osea 9 generamos un error
            	if (dni.length() != 8) {
	                error = "DNI con logitud diferente a 8";
	                Integer.parseInt("a");
	            }
	            // intentamos convertir los 8 primero caracteres a numeros y si no son numeros se genera el error solo
	            error = "DNI con error en el numero";
	            numero = Integer.parseInt(dni.substring(0, 8));
	            char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
	            pos = numero % 23;
	            letra = letras[pos];
	        } catch (Exception e) {
	            // le pasamos una cadena al constructor de la Excepcion
	            throw new DNIException(error);
	        }
	        return letra;
    	}
}

//no es normal declarar aqui otra clase, al ser 7 lineas comentarios incluidos no pasa nada
final class DNIException extends Exception {
	public DNIException(String cadena){
		// pasamos una cadena a la clase Extends y al pintar el stacktrace parece un error profesional XD
		super(cadena);
	}
}
