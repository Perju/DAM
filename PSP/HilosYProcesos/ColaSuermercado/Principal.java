package HilosYProcesos.ConsumidorProductor;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		// creamos el contenedor
		ColaSupermercado c = new ColaSupermercado();
		
		// creamos los productores y los consumidores asociados al Contenedor
		Cliente productorA = new Cliente(c);
		Cajera consumidorB = new Cajera(c);
		
		// iniciamos los procesos
		productorA.start();
		consumidorB.start();
	}
}

