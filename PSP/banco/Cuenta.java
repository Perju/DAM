package banco;
import java.util.Random;

public class Cuenta {
	public volatile int dinero;

	private static final int DINERO_INICIAL = 2000;

	private boolean activo = true;
	private boolean ocupado = false;

	private Random rnd;

	public Cuenta() {
		dinero=DINERO_INICIAL;
		rnd = new Random();
	}

	public synchronized boolean get() throws InterruptedException {	
		if(ocupado) {
				wait();	
		}else if(activo){
			ocupado=true;
			if(dinero<0) {
				System.out.println("Menos de 0");
				activo=false;
			} else {
				int cargo=(rnd.nextInt(401)+100);
				dinero-=cargo;
				System.out.println("Se saca: "+cargo+"€\tTotal: "+dinero);
			}
			ocupado=false;
			notifyAll();
		}
		return activo;
	}

	public synchronized boolean put() throws InterruptedException {
		if(ocupado) {
				wait();
		}else if(activo){
			ocupado=true;
			if(dinero>10000) {
				System.out.println("mas de 10k");
				activo=false;
			} else {
				int ingreso=(rnd.nextInt(401)+100);
				dinero+=ingreso;
				System.out.println("Se depositar: "+ingreso+"€\tTotal: "+dinero);
			}
			ocupado=false;
			notifyAll();	
		}
		return activo;
	}
}
