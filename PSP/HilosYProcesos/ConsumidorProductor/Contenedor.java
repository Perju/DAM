package HilosYProcesos.ConsumidorProductor;

import java.util.ArrayList;
import java.util.Random;

public class Contenedor {
	private ArrayList<Integer> data;
	
	private static final int MIN_PRODUCTOS = 0;
	private static final int MAX_PRODUCTOS = 20;
	private static final int PRODUCTOS_INICIALES = 10;

	// si hay un dato a si Hay muchos o pocos datos entre 0 y 20
	private boolean activo = true;
	
	private Random rnd;

	// Constructor
	public Contenedor() {
		data = new ArrayList<Integer>();
		rnd = new Random();
		for( int i = 0; i< PRODUCTOS_INICIALES; i++ ) {
			data.add(rnd.nextInt(69)+1);
		}
	}

	public synchronized int get(String nombre) {
		int valor = 0;
		if(!data.isEmpty()) {
			valor = data.get(0);
			data.remove(0);
			System.out.println(nombre+" obtiene el nº: " + valor);
		}
		if( activo == true && data.size() <= MIN_PRODUCTOS ) {
			activo = false;
			System.out.println("Se cierra la empresa por fin de existencias");
			System.exit(0);
		}
		return valor;
	}

	public synchronized void put(String nombre) {
		int valor = rnd.nextInt(20);
		data.add(valor);
		System.out.println(nombre+" coloca el nº: " +valor);
		if( activo == true && data.size() >= MAX_PRODUCTOS ) {
			activo = false;
			System.out.println("Cierra la empresa, exceso de stock");
			System.exit(0);
		}
	}
	
	// Getters & Setters
	public boolean activo() {
		return activo;
	}
}
