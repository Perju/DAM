/*1. Barco hundiéndose
El barco está haciendo aguas. Se está llenando de agua por un agujero en el casco mientras un
marinero intenta achicar el agua. Crea un programa usando Runnable para simular la situación con
las siguientes características:
· El agua inicial es 50 unidades de volumen.
· El barco se hunde si llega a 100 unidades de volumen.
· El marinero saca agua aleatoriamente pero cada vez menos (se cansa). Cada vez que se
activa saca de 1 a 10 unidades de volumen menos 1 por cada activación con un mínimo de 1.
· La entrada de agua es cada vez menor (el carpintero hace su trabajo). Cada vez que se activa
entra de 1 a 20 unidades de volumen menos una por activación con un mínimo de 0.
· De una activación a otra se tarda un milisegundo
· Se hundirá el barco?*/
package HilosYProcesos.HundirBarco;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Barco barco = new Barco();
		Marinero marinero = new Marinero(barco);
		Carpintero carpintero = new Carpintero(barco);
		
		new Thread(marinero).start();
		new Thread(carpintero).start();
		
		while( barco.estado() == 0 ) {
			Thread.sleep(1);
			barco.sunking();//el barco se hunde
		}
		
		if( barco.estado() == 1 ) {
			System.out.println("Se ha salvado");
		}else if( barco.estado() == -1 ) {
			System.out.println("El barco se ha undido");
		}
	}
}
