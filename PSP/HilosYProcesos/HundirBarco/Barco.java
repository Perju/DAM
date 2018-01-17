package HilosYProcesos.HundirBarco;

import java.util.Random;

public class Barco {
	
	private int volumenAgua;
	// puntos de entrada de agua reparados
	private int reparacion;
	private int roturas;
	// numero de activaciones
	private int iteraciones;
	private Random rnd;
	
	public Barco() {
		volumenAgua=50;
		reparacion=0;
		roturas=20;
		iteraciones=0;
		rnd=new Random();
	}
	
	public synchronized void achicando(int cantidad) throws InterruptedException {
		if(cantidad-iteraciones>0) {
			volumenAgua-=(cantidad-iteraciones);
			System.out.println("El marinero achica: "+(cantidad-iteraciones));
		}else {
			volumenAgua-=1;
			System.out.println("El marinero achica: 1");
		}
		
	}
	
	public synchronized void reparando() throws InterruptedException {
		if(reparacion<roturas)reparacion++;
		System.out.println("Se repara un agujero");
	}
	
	public synchronized void sunking() throws InterruptedException {
		volumenAgua+=rnd.nextInt(10)-reparacion;
		System.out.println("Entra agua al barco");
	}
	
	// devuelve 1 y esta todo ok
	// devuleve -1 si se hunde el barco
	// devuelve 0 en resto de las veces
	public int estado() {
		if(volumenAgua >=100) {
			return -1;
		}else if(volumenAgua <=0 && reparacion>=roturas) {
			return 1;
		}
		return 0;
	}
	
	public int getIteraciones() {
		return iteraciones;
	}
	
}
