package archivosBinarios;

import java.io.*;
import java.util.Random;

public class EscribirArchivoBinario {

	public static void main(String[] args) {
		// las cosas de siempre
		Random rnd = new Random();
		
		//getProperty("user.dir") devuelve el directorio de trajabo del usuario
		String home=System.getProperty("user.home");
		// creamos un objeto de tipo file pasandole solo un parametro
		// ojo que concateno dos cadenas y las paso como un solo parametro
		File directorio=new File(home+"/Documents/java");
		// formamos la ruta hasta el archivo aqui me olvido del separador de rutas /
		// y paso dos parametro un objeto file y una cadena
		File archivo=new File(directorio,"100enteros.out");
		
		try {
			// el flujo de los datos es al reves que la creacion de los objetos
			// por que necesitamos acceder al archivo al que queremos enviar los datos
			// un stream hacia un archivo de salida
			FileOutputStream fos=new FileOutputStream(archivo, false);
			// un stream de datos de salida
			DataOutputStream dos=new DataOutputStream(fos);
			// añadimos unos cuantos enteros al archivo
			for(int i=0;i<10;i++){
				dos.writeInt(rnd.nextInt(100));
			}
			// cerramos el stream de datos
			dos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("se acabo");

	}

}
