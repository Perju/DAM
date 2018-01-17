package HilosYProcesos.CrearProceso;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CrearProceso {

	public static void main(String[] args) {
		/*/ crear un proceso con ProcessBuilder y Process
		ProcessBuilder pb = new ProcessBuilder("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
		try {
			Process proceso = pb.start();
			proceso.waitFor(10, TimeUnit.SECONDS);
			proceso.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//*/
		
		// Crear un proceso con runtime
		Runtime runtime = Runtime.getRuntime();
		try {
			Process proceso = runtime.exec("notepad.exe");
			//mostramos la memoria libre
			System.out.println("Memoria libre: "+runtime.freeMemory());
			// hacemos cosas con el proceso
			proceso.waitFor(3, TimeUnit.SECONDS);
			proceso.destroy();
			//mostramos la memoria ejecutamos el garbage collector y la volvemos a mostrar
			System.out.println("Memoria Libre: "+runtime.freeMemory());
			runtime.gc();
			System.out.println("Memoria Libre: "+runtime.freeMemory());
			runtime.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
