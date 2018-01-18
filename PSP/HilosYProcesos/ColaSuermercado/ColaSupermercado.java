package HilosYProcesos.ConsumidorProductor;

public class ColaSupermercado {
	private int numClientes;
	
	private static final int MIN_PRODUCTOS = 0;
	private static final int MAX_PRODUCTOS = 10;
	private static final int PRODUCTOS_INICIALES = 5;

	// si hay un dato a si Hay muchos o pocos datos entre 0 y 20
	private boolean activo = true;

	// Constructor
	public ColaSupermercado() {
		numClientes=PRODUCTOS_INICIALES;
	}

	public synchronized void get() {
		numClientes--;
		System.out.println("Un cliente es atendido quedan: "+numClientes);
		if( activo == true && numClientes <= MIN_PRODUCTOS ) {
			activo = false;
			System.out.println("La cajera ha atendido a todos los clientes");
			System.exit(0);
		}
	}

	public synchronized void put() {
		numClientes++;
		System.out.println("Viene un cliente nuevo, ahora hay: "+numClientes);
		if( activo == true && numClientes >= MAX_PRODUCTOS ) {
			activo = false;
			System.out.println("Se han acumulado muchos clientes");
			System.exit(0);
		}
	}
	
	// Getters & Setters
	public boolean activo() {
		return activo;
	}
}
