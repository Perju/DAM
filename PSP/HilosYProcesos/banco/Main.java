package HilosYProcesos.banco;
public class Main {
	public static void main(String[] args) {
			// creamos los objetos necesarios
			Cuenta c=new Cuenta();
			Productor pagador=new Productor(c);
			Usuario pesetero = new Usuario(c,10);
			Usuario maniroto = new Usuario(c,4);
			// Instanciamos los hilos necesarios
			Thread t1=new Thread(pagador);
			Thread t2=new Thread(pesetero);
			Thread t3=new Thread(maniroto);
			// Iniciamos los nuevos hilos
			t3.start();
			t2.start();
			t1.start();
	}
}
