import java.util.InputMismatchException;
import java.util.Scanner;

public class Leer {
	//metodo para pedir enteros
	public static int pedirEntero(){
		int numero=0;
		boolean salir;
		Scanner kb= new Scanner(System.in);
		do{
			try{
				numero=kb.nextInt();
				salir=true;
			}catch(InputMismatchException e){
				System.out.println("Introduce solo numeros enteros");
				salir=false;
			}
		}while(!salir);
		return numero;
	}
	//metodo para pedir un numero Float
	public static float pedirFloat(){
		float numero=0;
		boolean salir;
		Scanner kb= new Scanner(System.in);
		do{
			try{
				numero=kb.nextFloat();
				salir=true;
			}catch(InputMismatchException e){
				System.out.println("Introduce solo numeros enteros");
				salir=false;
			}
		}while(!salir);
		return numero;
	}
	//metodo para pedir un numero Double
	public static double pedirDouble(){
		double numero=0;
		boolean salir;
		Scanner kb= new Scanner(System.in);
		do{
			try{
				numero=kb.nextDouble();
				salir=true;
			}catch(InputMismatchException e){
				System.out.println("Introduce solo numeros enteros");
				salir=false;
			}
		}while(!salir);
		return numero;
	}
	// para leer solo la primera palabra escrita por teclado
	public static String pedirPalabra(){
		String palabra="";
		boolean salir;
		Scanner kb=new Scanner(System.in);
		do{
			try{
				palabra=kb.next();
				salir=true;
			}catch(Exception e){
				e.printStackTrace();
				salir=false;
			}
		}while(!salir);
		return palabra;
	}
	// para leer toda la cadena introducida por teclado
	public static String pedirCadena(){
		String palabra="";
		boolean salir;
		Scanner kb=new Scanner(System.in);
		do{
			try{
				palabra=kb.nextLine();
				salir=true;
			}catch(Exception e){
				e.printStackTrace();
				salir=false;
			}
		}while(!salir);
		return palabra;
	}
	// pedir un caracter
	public static char pedirCaracter(){
		char caracter='\n';
		String cadena;
		boolean salir;
		Scanner kb=new Scanner(System.in);
		do{
			try{
				cadena=kb.nextLine();
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
