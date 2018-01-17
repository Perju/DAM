package HilosYProcesos.Buceadores;

import java.util.Random;
// implementamos runable en nuestra clase
// para poder crear un hilo con esta Clase "this Class"
public class Buceador implements Runnable{
	private int unidadesOxigeno;
	private int distanciaSuperficie;
	private String nombre;
	private boolean activo;
	Random rnd;
	// y añadimos un objeto Thread para crear un subproceso
	Thread t;
	
	public Buceador(String nombre) {
		unidadesOxigeno=15;
		distanciaSuperficie=20;
		activo=true;
		this.nombre=nombre;
		// creamos un nuevo hilo a partir de esta clase
		t = new Thread(this);
		rnd = new Random();
	}

	@Override
	public void run() {
		int longStep,udsOxigen;
		while(activo) {
			// subimos metros, consumimos oxigeno y mostramos los resultados
        	longStep=rnd.nextInt(5)+1;
        	udsOxigen=rnd.nextInt(3)+1;
            this.distanciaSuperficie-=longStep;
            this.unidadesOxigeno-=udsOxigen;
            System.out.println("El Buceador: "+this+" asciende "+longStep+" metros y gasta "+udsOxigen+" unidades de oxigeno\n"
            		+ " le quedan "+this.distanciaSuperficie+"m para alcanzar la superficie y "+this.unidadesOxigeno+"uds de Oxigeno");
            // comprobacion de la llegada o muerte y mostramos el resultado
            if(this.distanciaSuperficie<=0 && this.unidadesOxigeno>=0) {
            	System.out.println("!!!Ha llegado!!!: "+this+" ha logrado salir vivo");
            	this.stop();
            }else if(this.unidadesOxigeno<0) {
            	System.out.println(this+" ha muerto en el intento");
            	this.stop();
            }
            // un descanso
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}//fin run
	
	public void start() {
		t.start();
	}
	
	public void stop() {
		activo=false;
	}
	
	public String toString() {
		return nombre;
	}

}
