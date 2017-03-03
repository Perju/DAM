package juegos01;
 
import java.util.Scanner;
import java.util.Random;

public class TragaPerras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		Random rnd = new Random();
		String simbolos="$#%<>@", resultado="", combinacion="$$$ $@@ $## @@@ @## @$$ ### %%% <<< >>> $@%";
		int azar, credito=10, N, aumentarCredito=0, fondoMaquina=100, premio=0, totalPremio=0;
		boolean hayDinero=false;
		
		//bucle principal del juego
		do{
			do{//generamos un nuevo resultado si no hay suficiente dinero para dar premio
				//generamos un resultado aleatorio
				//primero reiniciamos el resultado
				resultado="";
				for	(int i=0;i<3;i++){
					azar=rnd.nextInt(6);
					resultado+=simbolos.charAt(azar);
				}
				// comprobamos si el resultado existe entre las combinaciones ganadoras
				if(combinacion.indexOf(resultado)==0){
					premio=50;
				}else if(combinacion.indexOf(resultado)==4){
					premio=25;
				}else if(combinacion.indexOf(resultado)==8){
					premio=15;
				}else if(combinacion.indexOf(resultado)==12){
					premio=10;
				}else if(combinacion.indexOf(resultado)==16){
					premio=5;
				}else if(combinacion.indexOf(resultado)==20){
					premio=3;
				}else if(combinacion.indexOf(resultado)>=24){
					premio=1;
				}else{
					premio=0;//si no hay coincidencias el premio es cero
					//a partir de ahora se imprime en el if(premio>0){hay premio}else{AQUI!!!}
					//System.out.println("No hay premio PRINGAO");//se muestra si no hay premio
				}
				/* comprobamos si hay dinero suficiente 
				 * Hay dinero suficente si el total repartido en premios mas el premio
				 * es menor que el 60% del fondoMaquina mas el total de premio ya repartidos
				 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
				if(premio+totalPremio>0.6*(fondoMaquina+totalPremio)){
					hayDinero=false;
				}else{ //si no se da el premio
					hayDinero=true;
				}
				
			}while(hayDinero==false);//mientras no hay dinero se generan nuevos resultados
			// mostramos el resultado
			System.out.println("\t╔═══╦═══╦═══╗");
			System.out.println("\t║ "+resultado.charAt(0)+" ║ "+resultado.charAt(1)+" ║ "+resultado.charAt(2)+" ║");
			System.out.println("\t╚═══╩═══╩═══╝");
			
			if(premio>0){//mostramos si ha tocado premio
				System.out.println("\nHAS GANADO "+premio+"!!");
			}else{
				System.out.println("No hay premio PRINGAO");
			}
				
			System.out.println("\nTe quedan "+credito+" euros\n");
			
			// calculamos
			fondoMaquina-=premio;
			credito+=premio;
			credito-=1;
			fondoMaquina+=1;
			premio=0;
			// calculo paso 2
			totalPremio+=premio;
			
			//preguntamos al usuario que quiere hacer
			if(credito>=1){					//preguntar si seguir o cobrar
				System.out.println("Elije una opcion:");
				System.out.println("1. Seguir jugando");
				System.out.println("2. Cobrar");
				System.out.println("3. Insert coin");
				N = teclado.nextInt();
					if(N==2){ //cobrar
						System.out.println("Has ganado: "+credito);
						credito=0;
					}else if(N==3){ //insertar credito
						System.out.println("Inserte credito: ");
						aumentarCredito= teclado.nextInt();
						credito += aumentarCredito;
						System.out.println("Su credito es de: "+credito+"\n\n");
					}
				}else{ //no queda credito
					System.out.println("No te queda dinero");
				}
		}while(credito>0);
	}
}