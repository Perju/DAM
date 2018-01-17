/*
 * Ejercicio 2. Variante de productor y consumidor
 * Tenemos dos consumidores, con prioridad normal y m�nima, y dos productores,
 * con prioridad normal y m�xima. Al empezar tenemos 10 unidades de producto
 * en el contenedor. Productores y consumidores proporcionan y adquieren
 * producto hasta que el producto llegue a 0 � 20. Avisar cuando se a�ada o quite
 * producto y cuando acabe.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package HilosYProcesos.ConsumidorProductor;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		// creamos el contenedor
		Contenedor c = new Contenedor();
		
		// creamos los productores y los consumidores asociados al Contenedor
		Productor productorA = new Productor(c,"Productor A");
		Consumidor consumidorB = new Consumidor(c,"Consumidor B");
		Productor productorC = new Productor(c,"Productor C");
		Consumidor consumidorD = new Consumidor(c,"Consumidor D");
		
		// establecemos prioridades
		productorA.setPriority(Thread.NORM_PRIORITY);
		consumidorB.setPriority(Thread.MAX_PRIORITY);
		productorC.setPriority(Thread.MIN_PRIORITY);
		consumidorD.setPriority(Thread.MAX_PRIORITY);
		
		// iniciamos los procesos
		productorA.start();
		consumidorB.start();
		productorC.start();
		consumidorD.start();
	}
}
// conclusion como el contenedor tiene mas instrucciones al eliminar un objeto del ArrayList
// al Consumidor gasta mas recuros que el Productor, y para equilibrar la balanza hay 
// que darle mas prioridad a los


