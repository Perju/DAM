package dni;

public class DNIFormatoCadenaIncorrecto extends Exception {
	DNIFormatoCadenaIncorrecto(String cadena){
		// pasamos una cadena a la clase Extends y al pintar el stacktrace parece un error profesional XD
		super(cadena);
	}
}
