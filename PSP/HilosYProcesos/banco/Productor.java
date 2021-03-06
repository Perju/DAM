package HilosYProcesos.banco;

public class Productor implements Runnable {
	private Cuenta cuenta;

	public Productor(Cuenta contenedor) {
		this.cuenta=contenedor;
	}

	@Override
	public void run()  {
		try {
			while(cuenta.put()) {
				Thread.sleep(10);
			}System.out.println("se acabo");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
