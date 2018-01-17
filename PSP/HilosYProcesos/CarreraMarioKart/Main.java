/*2. Carrera de Mario Kart
Simula una carrera de Mario Kart con cinco corredores (Mario, Luigi, Yoshi, Boo y Huesitos)
usando Thread. Las condiciones de la carrera son:
• El total a recorrer es 1000 metros
• Cada vez que se activa un personaje puede pasar lo siguiente:
✗ No pasa nada, avanza de 21 a 40 metros (45%)
✗ Choca con algo o sale de la pista, no avanza nada (20%)
✗ Cae en una trampa, retrocede de 11 a 20 metros (20%)
✗ Obtiene un propulsor, avanza de 51 a 100 metros (15%)
✗ De una activación a otra se tarda 5 milisegundos
¿Quién es el ganador?*/
package HilosYProcesos.CarreraMarioKart;

public class Main {
	public static void main(String[] args) {
		// nombres de los corredores
		String nombresPilotos[] = {"Mario", "Luigi", "Yoshi", "Boo" ,"Huesitos"};
		// declaramos los corredores
		Corredor corredores[] = new Corredor[nombresPilotos.length];
		// instanciamos los corredores
		for(int i=0; i<corredores.length;i++) {
			corredores[i]= new Corredor(Thread.NORM_PRIORITY,nombresPilotos[i]);
			corredores[i].start();
		}
		
		boolean activos=true;
		while(activos) {
			activos=false;
			for(Corredor runer: corredores) {
					activos=(runer.isAlive() || activos);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println("Hasta la proxima carrera");
	}
}
