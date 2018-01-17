package HilosYProcesos.ConsumidorProductor;

public class Productor extends Thread {

	private Contenedor contenedor;

	private String nombre;

	public Productor(Contenedor contenedor, String nombre) {
		this.contenedor=contenedor;
		this.nombre=nombre;
	}

	@Override
	public void run(){
			while(contenedor.activo()) {
				contenedor.put(this.toString());
				// para que vaya todo pasito a pasito y funcione logicamente
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {System.err.println("InterruptedException Error");}
			}
	}

	public String toString() {
		return nombre;
	}

}
