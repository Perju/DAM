package HilosYProcesos.HundirBarco;

public class Carpintero implements Runnable{

	Barco barco;
	
	public Carpintero(Barco barco) {
		this.barco=barco;
	}
	
	@Override
	public void run() {
		while(barco.estado()==0) {
			try {
				barco.reparando();
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
