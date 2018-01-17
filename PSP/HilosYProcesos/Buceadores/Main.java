/*Ejercicio 1.
Carrera de tres buceadores hasta la superficie con las siguientes condiciones:
 Superficie a 20 metros
 Cada buceador tiene 15 unidades de oxígeno en la bombona
 Cada vez que se activa, un buceador avanza de uno a cinco metros
 Al activarse se consume de una a tres unidades de oxígeno
Crea un programa que simule cómo avanza los buceadores y, finalmente
indique si llega a la superficie o se ahoga, en cuyo caso añadir cuánto le queda
para la superficie.*/
package HilosYProcesos.Buceadores;

public class Main {
	// throws para no usar todo un bloque try{}catch{} para Thread.sleep(500) 
	public static void main(String[] args) throws InterruptedException{
		// un array para los nombres
		String nombres[]= {"Juan","Pablo","Francisco","Jose","Angel","Ana","Carmen","Catalina"};
		// un array para guardar los corredores
		Buceador buceadores[]= new Buceador[3];
		// un bucle para construirlos y ejecutarlos
		for(int i=0;i<buceadores.length;i++) {
			buceadores[i]=new Buceador(nombres[i]);
			buceadores[i].start();
		}
		boolean activos=true;
		while(activos) {
			activos=false;
			for(Buceador diver : buceadores) {
				if(diver.t.isAlive()) {
					activos=true;
				}	
			}

		Thread.sleep(500);

		}
		System.out.println("Hasta la proxima carrera");
	}
}


