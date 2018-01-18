package HilosYProcesos.ConsumidorProductor;

import java.util.Random;

public class Cliente extends Thread {

	private ColaSupermercado contenedor;

	
	private static Random rnd= new Random();
	private int time;

	public Cliente(ColaSupermercado contenedor) {
		this.contenedor=contenedor;
	}

	@Override
	public void run(){
			while(contenedor.activo()) {
				contenedor.put();
				// para que vaya todo pasito a pasito y funcione logicamente
				try {
					time=rnd.nextInt(5)+3;
					Thread.sleep(time);
				} catch (InterruptedException e) {System.err.println("InterruptedException Error");}
			}
	}
}
