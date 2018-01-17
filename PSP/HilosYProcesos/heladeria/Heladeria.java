package HilosYProcesos.heladeria;

import java.util.concurrent.Semaphore;

public class Heladeria {
	//cantidad de helados
	private int helados;
	Semaphore heladeros;
	// quedan helados o no
	private boolean activo=true;

	//constructor
	public Heladeria(){
		this.helados=30;
		heladeros = new Semaphore(2);
	}

	// el heladero obtiene un helado de la camara
	public void heladeroCogeHelado() throws InterruptedException {
		heladeros.acquire();// añadimos un permiso al semaforo
		helados--;
	}

	// el heladero entrega un helado a quien se lo pida
	public void heladeroEntregaHelado() throws InterruptedException {
		if(helados>0) {
			heladeros.release();// liberamos un permiso del semaforo	
		} else {
			activo=false;
		}
	}
	
	public boolean isActivo() {
		return activo;
	}
}
