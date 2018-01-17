package HilosYProcesos.ConsumidorProductor;

public class Consumidor extends Thread {
	
	private Contenedor contenedor;

	private String nombre;
	
	public Consumidor(Contenedor contenedor,String nombre) {
		this.contenedor = contenedor;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		try {
			while(contenedor.activo()) {
				contenedor.get(this.toString());
				Thread.sleep(1);
			}	
		}catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
