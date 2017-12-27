package juegosTerminal;

import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

	public static void main(String[] args) {
		// variables
		String palabra="", palabraOculta="", palabraEnProceso="";
		char letra=' ';
		boolean salir=false;
		String palabrasPaResolver[]={"Rinoceronte","Microchip","Estupedo","Maniatico","perpetuidad"};
		Scanner teclado = new Scanner(System.in);
		Random rnd = new Random();
		int fallos=0;
		
		do{
			// elegimos una palabra al azar
			palabra=palabrasPaResolver[rnd.nextInt(5)];
			palabraOculta="___________".substring(0,palabra.length());
			fallos=0;
			
			
			do{
				//pedimos una letra al usuario
				System.out.println("\nLa Palabra es: "+palabraOculta);
				System.out.println("Llevas "+fallos+" fallos.");
				System.out.println("Por favor introduce una letra");
				letra=teclado.next().charAt(0);
				
				
				
				// anañidos la letra a la palabra si existe creando una nueva cadena
				if(palabra.indexOf(letra)>=0){
					for(int i=0;i<palabra.length();i++){
						if(palabra.toLowerCase().charAt(i)==palabraOculta.toLowerCase().charAt(i)){
							palabraEnProceso+=palabra.charAt(i);
						}else if(palabra.toLowerCase().charAt(i)==letra){
							palabraEnProceso+=palabra.charAt(i);
						}else{
							palabraEnProceso+="_";
						}
					}
				}else{
					fallos++;
				}
				if(palabraEnProceso.length()==palabra.length()){
					//asignamos la palabra creada
					palabraOculta=palabraEnProceso;
					palabraEnProceso="";
				}
				//comprobamos si la palabra esta acertada por completo
				if(palabra.equals(palabraOculta)){
					fallos=6;
				}
				
				
			}while(fallos<5);// fin de la partida
			
			if(fallos==5){
				System.out.println("Has perdido mangurrial");
				System.out.println("La palabra era: "+palabra);
			}else if(fallos==6){
				System.out.println("Has acertado la palabra");
			}else{
				System.out.println("Que cojones pasa aquí");
			}
			
			//preguntamos al usuario si quiere volver a jugar
			System.out.println("¿Desea jugar otra partida? s/n");
			letra=teclado.next().toLowerCase().charAt(0);
			if(letra=='s'){
				salir=false;
			}else if(letra=='n'){
				salir=true;
			}else{
				System.out.println("Elige una opcion");
			}
			
		}while(!salir);
		// cerramos el teclado antes de salir
		teclado.close();
	}
}
