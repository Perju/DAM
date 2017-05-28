package archivosDeTexto;

import java.io.*;

public class LeerArchivoDeTexto {

	public static void main(String[] args) {
		//getProperty("user.dir") devuelve el directorio de trajabo del usuario
		String home=System.getProperty("user.home");
		// formamos una ruta de directorios hasta la carpeta que se ve como mis documentos
		File directorio=new File(home+"/Documents/java");
		// formamos la ruta hasta el archivo
		File archivo=new File(directorio,"README.txt");
		try {
			// un filereader para leer el archivo
			FileReader	fr = new FileReader(archivo);
			// un buffered reader para leer lineas de texto
			BufferedReader br= new BufferedReader(fr);
			// bucle con lectura anticipada
			String s="";
			while(s!=null){
				System.out.println(s);
				s=br.readLine();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
		}
		
		
	}

}
