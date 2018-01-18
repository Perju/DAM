package HilosYProcesos.CarreraMarioKart;

import java.util.Random;

public class Mula implements Runnable {
	
	String nombre;
    Thread t;
	
    private int RUN_LENGTH=0;
	private int metros = 0;
	private static Random rnd= new Random();
    
    private volatile boolean running = true;

    // constructor
    public Mula(int run_length,String nombre) {
        this.nombre=nombre;
    	t = new Thread(this);
    	this.RUN_LENGTH=run_length;
    }

    // llamar a este metodo no crea un nuevo hilo
    @Override
    public void run() {
    	int mStep;
    	String strDireccion;
        while (running) {
            mStep=rnd.nextInt(41)-10;
        	//añadimos la distancia
        	this.metros+=mStep;
        	if(mStep==0) {
        		strDireccion=" no avanza ";
        	}else {
        		strDireccion=(mStep>0)?// (condicion)? true : false;
        				" avanza "+mStep+" metros ":" retrocede "+Math.abs(mStep)+" metros ";
        	}
            System.out.println("La mula: "+this+strDireccion+mStep+"y lleva recorridos"+this.metros);
            // el corredor descansa 5ms
            try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            // el corredor se da cuenta si ha cruzado la meta o no
            if(this.metros>=RUN_LENGTH) {
            	System.out.println("¡¡¡"+this+" ha llegado!!!: "+this+" es una Mula increible");
            	this.stop();
            }
        }
    }

    public void stop() {
        running = false;
    }
    // el metodo start crea un nuevo hilo y llama a run
    public void start() {
        t.start();
    }
    
    // para usar como this.toString() o simplemente this
    public String toString() {
    	return nombre;
    }
    
    public boolean isAlive() {
    	return t.isAlive();
    }
}
