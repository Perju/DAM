package HilosYProcesos.ColaSuermercado;

import java.util.Random;

public class Cajera extends Thread {
	
	private ColaSupermercado contenedor;
	
	private Random rnd= new Random();
	private int time;
	
	public Cajera(ColaSupermercado contenedor) {
		this.contenedor = contenedor;
	}
	
	@Override
	public void run() {
		try {
			while(contenedor.activo()) {
				contenedor.get();
				time=rnd.nextInt(3)+4;
				Thread.sleep(time);
			}	
		}catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
}
