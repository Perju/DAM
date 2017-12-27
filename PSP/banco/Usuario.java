package banco;

public class Usuario implements Runnable {
	private Cuenta cuenta;
	private int tiempo;

	public Usuario(Cuenta cuenta, int tiempo) {
		this.cuenta=cuenta;
		this.tiempo=tiempo;
	}

	@Override
	public void run() {
		try {
			boolean mientras=true;
			while(mientras) {
				mientras=cuenta.get();
				Thread.sleep(tiempo);
			}System.out.println("se acabo");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
