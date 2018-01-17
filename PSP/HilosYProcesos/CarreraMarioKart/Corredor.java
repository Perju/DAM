package HilosYProcesos.CarreraMarioKart;

import java.util.Random;

public class Corredor implements Runnable {
	
	public static final int RUN_LENGTH=1000;
	
	String nombre;
    Thread t;
	
	private double probabilidad;
	private int metros = 0;
	private static Random rnd= new Random();
    
    
    private volatile boolean running = true;

    // constructor
    public Corredor(int p,String nombre) {
        t = new Thread(this);
        t.setPriority(p);
        this.nombre=nombre;
    }

    // llamar a este metodo no crea un nuevo hilo
    @Override
    public void run() {
    	int mStep;
        while (running) {
        	probabilidad = rnd.nextDouble();
        	if(probabilidad<0.15) {
            	mStep=new Random().nextInt(50)+51;
        	}else if(probabilidad<0.35) {
        		mStep=new Random().nextInt(10)+11;
        	}else if(probabilidad<0.55) {
        		mStep=0;
        	}else  {
        		mStep=new Random().nextInt(20)+21;
        	}
        	//añadimos la distancia
        	this.metros+=mStep;
            System.out.println("El corredor: "+this+" avanza "+mStep+" metros y lleva "+this.metros);
            // el corredor descansa 5ms
            try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            // el corredor se da cuenta si ha cruzado la meta o no
            if(this.metros>=RUN_LENGTH) {
            	System.out.println("¡¡¡"+this+"Ha llegado!!!: "+this+" es todo un crack");
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
