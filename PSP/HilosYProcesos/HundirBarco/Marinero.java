package HilosYProcesos.HundirBarco;

import java.util.Random;

public class Marinero implements Runnable {

	Barco barco;
	Random rnd;
	
	public Marinero(Barco barco) {
		this.barco=barco;
		rnd=new Random();
	}
	
	@Override
	public void run() {
		while(barco.estado()==0) {
			try {
				barco.achicando(rnd.nextInt(1));
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}	
}
