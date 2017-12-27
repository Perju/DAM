package almacenarObjetoSpinner;

import java.io.*;
import java.util.Random;

public class objetosGuardadosEnArchivos {
	
	public static Spinner crearSpiner(){
		Random rnd=new Random();
		String[]  nombres={"AP","MO","CO","TA","CA","PU"};
		String nombrespiner;// se concatenaran dos silabas del array String[] nombres
		int durabilidad;
		int rodamientos;
		
		nombrespiner = nombres[rnd.nextInt(6)] + nombres[rnd.nextInt(6)];
		durabilidad = rnd.nextInt(10)+1;//[0-9]+1==[1-10]
		rodamientos = rnd.nextInt(7)+1;//[0-7]+1==[1-7]

		return new Spinner(nombrespiner,rodamientos,durabilidad);
	}
	
	public static void anadirSpinerA(Spinner spin,File archivo){
		
		try {
			FileOutputStream fos=new FileOutputStream(archivo, true);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(spin);
			oos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Sin acceso al archivo");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void mostrarSpinerDe(File archivo) {
		try {
			FileInputStream fis=new FileInputStream(archivo);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Spinner spin=(Spinner) ois.readObject();
			ois.close();
			while(true){
				System.out.println(spin);
				spin=(Spinner) ois.readObject();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Sin acceso al archivo");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("clase no encontrada");
		}	
	}

	public static void main(String[] args) {

		//creamos un spiner aleatoriamente
		//Spinner spin=crearSpiner();
		//lo pintamos en el terminal
		//System.out.println(spin);
		
		//creamos un objeto de tipo file como en los otros ejemplos
		String home=System.getProperty("user.home");
		File directorio=new File(home+"/Documents/java");
		File archivo=new File(directorio,"spiner.out");
		
		// guardamos el spiner en el archivo
		//anadirSpinerA(spin,archivo);
		
		mostrarSpinerDe(archivo);

	}
}
