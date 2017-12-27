package archivosDeTexto;

import java.io.*;

public class Leer {
	//metodo para pedir enteros
	public static int pedirEntero(String texto){
		int numero=0;
		boolean salir;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		do{
			//para mostrar el texto que se pasa por parametro si es que se pasa
			texto= texto.length()<=0 ?texto :texto+"\n";//si el texto es de longitud 0 se deja como esta
			System.out.print(texto);					//y si no le añadimos un salto de linea
			try{
				numero=Integer.parseInt(br.readLine());
				salir=true;
			}catch(NumberFormatException e){
				System.out.println("Introduce solo numeros enteros");
				salir=false;
			} catch (IOException e) {
				System.out.println("Error de entrada");
				salir=false;
			}
		}while(!salir);
		return numero;
	}
	//metodo para pedir un numero Float
	public static float pedirFloat(String texto){
		float numero=0;
		boolean salir;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		do{
			texto= texto.length()<=0 ?texto :texto+"\n";
			System.out.print(texto);
			try {
				numero=Float.parseFloat(br.readLine());
				salir=true;
			} catch (NumberFormatException e) {
				System.out.println("Solo numeros por favor");
				salir=false;
			} catch (IOException e) {
				System.out.println("Error de entrada");
				salir=false;
			}
		}while(!salir);
		return numero;
	}
	//metodo para pedir un numero Double
	public static double pedirDouble(String texto){
		double numero=0;
		boolean salir;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		do{
			texto= texto.length()<=0 ?texto :texto+"\n";
			System.out.print(texto);
			try{
				numero=Double.parseDouble(br.readLine());
				salir=true;
			}catch (NumberFormatException e) {
				System.out.println("Solo se admiten numeros de tipo Double");
				salir=false;
			} catch (IOException e) {
				System.out.println("Error de entrada");
				salir=false;
			}
		}while(!salir);
		return numero;
	}
	// para leer solo la primera palabra escrita por teclado
	public static String pedirPalabra(String texto){
		String cadena="";
		String palabra="";
		boolean salir;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		do{
			texto= texto.length()<=0 ?texto :texto+"\n";
			System.out.print(texto);
			try {
				cadena=br.readLine();
				if(cadena.split(" ").length>0){
					palabra=cadena.split(" ")[0];
					salir=true;
				}else{
					salir=false;
				}	
			} catch (IOException e) {
				System.out.println("Error general");			
				salir=false;
			}
		}while(!salir);
		return palabra;
	}
	// para leer toda la cadena introducida por teclado
	public static String pedirCadena(String texto){
		String cadena="";
		boolean salir;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		do{
			texto= texto.length()<=0 ?texto :texto+"\n";//si el texto es de longitud 0 se deja como esta
			System.out.print(texto);					//y si no le añadimos un salto de linea
			try{
				cadena=br.readLine();
				salir=true;
			}catch(Exception e){
				e.printStackTrace();
				salir=false;
			}
		}while(!salir);
		return cadena;
	}
	// pedir un caracter
	public static char pedirCaracter(String texto){
		char caracter='\n';
		String cadena;
		boolean salir;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		do{
			texto= texto.length()<=0 ?texto :texto+"\n";
			System.out.print(texto);
			try{
				cadena=br.readLine();
				if(cadena.length()==1){
					caracter=cadena.charAt(0);
					salir=true;
				}else{
					salir=false;
					System.out.println("He pedido solo un caracter");
				}
			}catch(Exception e){
				e.printStackTrace();
				salir=false;
			}
		}while(!salir);
		return caracter;
	}
}