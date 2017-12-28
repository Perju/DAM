package Ficheros.archivosDeTexto;

import java.io.*;


public class EcribirArchivoDeTexto {

	public static void main(String[] args) {
		//getProperty("user.dir") devuelve el directorio de trajabo del usuario
		String home=System.getProperty("user.home");
		// formamos una ruta de directorios hasta la carpeta que se ve como mis documentos
		File directorio=new File(home+"/Documents/java");
		// formamos la ruta hasta el archivo
		File archivo=new File(directorio,"prueba.txt");
		// true para añadir, false para crear archivo nuevo
		boolean add=false;
		try {
			FileWriter fw=new FileWriter(archivo, add);
			String s=Leer.pedirCadena("Dame cadenas de texto y termina con \"fin\"");
			while(s!=null && !s.toLowerCase().equals("fin")){
				fw.write(s+"\r\n");
				s=Leer.pedirCadena("");
			}
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("se fini");
	}

}
