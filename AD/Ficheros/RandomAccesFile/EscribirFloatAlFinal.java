package Ficheros.RandomAccesFile;

import java.io.*;

public class EscribirFloatAlFinal {

	public static void main(String[] args) {
		//getProperty("user.dir") devuelve el directorio de trajabo del usuario
		String home=System.getProperty("user.home");
		// creamos un objeto de tipo file pasandole solo un parametro
		// ojo que concateno dos cadenas y las paso como un solo parametro
		File directorio=new File(home+"/Documents/java");
		// formamos la ruta hasta el archivo aqui me olvido del separador de rutas /
		// y paso dos parametro un objeto file y una cadena
		File archivo=new File(directorio,"100enteros.out");
		// segundo parametro "rw" para dar permisos de lectura y escritura
		try {
			RandomAccessFile archivoAccesoAleatorio =new RandomAccessFile(archivo,"rw");
			long finArchivo=archivoAccesoAleatorio.length();
			archivoAccesoAleatorio.seek(finArchivo);
			//100 numeros de tipo float al final del archivo archivo
			for(int i=0;i<10;i++){
				//archivoAccesoAleatorio.writeFloat(rnd.nextFloat());
			}
			// vamos al principio del archivo
			archivoAccesoAleatorio.seek(0);
			// leemos los 10 primeros enteros del otro ejemplo
			for(int i=0;i<10;i++){
				System.out.println(archivoAccesoAleatorio.readInt());
			}
			// mostramos los 10 float siguientes
			for(int i=0;i<10;i++){
				System.out.println(archivoAccesoAleatorio.readFloat());
			}
			archivoAccesoAleatorio.close();
		} catch (FileNotFoundException e) {
			System.out.println("no se ha encontrado o no se tiene acceso al archivo");
		} catch (IOException e) {
			System.out.println("Error generico de E/S");
		}
	}
}
