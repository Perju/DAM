package HilosYProcesos.Carrera;

import java.util.Random;

public class Corredor implements Runnable {

	int metros = 0;
    String nombre;
    Thread t;
    
    private volatile boolean running = true;

    public Corredor(int p,String nombre) {
        t = new Thread(this);
        t.setPriority(p);
        this.nombre=nombre;
    }

    @Override
    public void run() {
        while (running) {
        	int mStep=new Random().nextInt(5)+1;
            this.metros+=mStep;
            System.out.println("El corredor: "+this+" avanza "+mStep+" metros y lleva "+this.metros);
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            if(this.metros>=100) {
            	System.out.println("!!!Ha llegado!!!: "+this+" es todo un crack");
            	this.stop();
            }
        }
    }

    public void stop() {
        running = false;
    }
    // el metodo start llama al metodo run automaticamente
    public void start() {
        t.start();
    }
    
    // para imprimir el nombre del corredor
    public String toString() {
    	return nombre;
    }
}