package Ficheros.archivosBinarios;

import java.io.*;

public class LeerArchivoBinario {

	public static void main(String[] args) {
		//getProperty("user.dir") devuelve el directorio de trajabo del usuario
		String home=System.getProperty("user.home");
		// creamos un objeto de tipo file pasandole solo un parametro
		// ojo que concateno dos cadenas y las paso como un solo parametro
		File directorio=new File(home+"/Documents/java");
		// formamos la ruta hasta el archivo aqui me olvido del separador de rutas /
		// y paso dos parametro un objeto file y una cadena
		File archivo=new File(directorio,"100enteros.out");
		
		try {
			// a la hora de leer si que se lleva el mismo orden de creacio de objetos
			// que la direccion de los datos
			// un stream desde un archivo de entrada
			FileInputStream fis=new FileInputStream(archivo);
			// un stream de datos de entrada
			DataInputStream dis=new DataInputStream(fis);
			// mientras queden bytes por leer
			while(dis.available()>0){
				// leemos y lo pasamos en direccion a la salida estandar
				System.out.println(dis.readInt());
			}
			// cerramos el stream de datos
			dis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("se acabo");

	}

}
