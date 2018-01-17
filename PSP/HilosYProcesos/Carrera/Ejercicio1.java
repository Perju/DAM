/* Ejercicio 1. Carrera de 100 metros
 * Crear una carrera de 100 metros con 8 corredores. Cada vez que se active un
 * corredor mueve de 1 a 5 metros. Cuando un corredor llega a los 100 metros
 * avisa qu� hilo ha llegado. */

package HilosYProcesos.Carrera;

public class Ejercicio1 {
	public static void main(String[] args) {
		// un array para los nombres
		String nombres[]= {"Juan","Pablo","Francisco","Jose","Angel","Ana","Carmen","Catalina"};
		// un array para guardar los corredores
		Corredor corredores[]= new Corredor[8];
		// un bucle para construirlos y ejecutarlos

		for(int i=0;i<nombres.length;i++) {
			corredores[i]=new Corredor(5,nombres[i]);
			corredores[i].start();
		}
		boolean activos=true;
		while(activos) {
			activos=false;
			for(Corredor runer: corredores) {
				activos=(runer.t.isAlive()||activos);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println("Hasta la proxima carrera");
	}
}
