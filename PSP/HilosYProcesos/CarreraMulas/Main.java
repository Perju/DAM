package HilosYProcesos.CarreraMulas;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random rnd = new Random();
		int numMulas=0, distanciaRecorrer=0;
		while(numMulas<5 || numMulas>8 ) {
			numMulas=Leer.pedirEntero("Dime ¿Cuantas mulas quieres que participen en la carrera? (entre 5 y 8)");
		}
		while(distanciaRecorrer<2000 || distanciaRecorrer>3000 ) {
			distanciaRecorrer=Leer.pedirEntero("Dime ¿Cuantos metros quieres que recorran las mulas? (entre 2000 y 3000)");
		}
		// nombres de los corredores
		String nombresMulas[] = {"mu", "ti", "ta", "co" , "bo", "la", "ca"};
		// declaramos los corredores
		Mula mulas[] = new Mula[numMulas];
		// instanciamos los corredores
		String nombreMula;
		for(int i=0; i<mulas.length;i++) {
			nombreMula=nombresMulas[rnd.nextInt(nombresMulas.length)]+nombresMulas[rnd.nextInt(nombresMulas.length)];
			mulas[i]= new Mula(distanciaRecorrer,nombreMula);
			mulas[i].start();
		}
		
		boolean activos=true;
		while(activos) {
			activos=false;
			for(Mula runer: mulas) {
					activos=(runer.isAlive() || activos);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println("Hasta la proxima carrera");
	}
}
