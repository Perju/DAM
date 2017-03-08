package pruebas;
// imports necesarios
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SonidoJavaIO {
	// Una clase que te pide un string para usarlo como ruta
	private InputStream path;

	public SonidoJavaIO(String path){
		// hay que usar el getResource de la clase principal
		// usando el .class. para poder acceder a las cosas que heredan todas las clases
		this.path = MainClass.class.getResourceAsStream(path);
	}

	public void reproducirSonido(int tiempo) throws InterruptedException{
		try
		{
			//cargamos el sonido y empezamos a reproducirlo
			Clip sonido = AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(this.path));
			sonido.start();
		}
		catch(Exception fallo)
		{
			System.out.println(fallo);
		}
		// para esperar el tiempo necesario hasta que se reproduzca el sonido en milisegundos.
		Thread.sleep(tiempo);
	}
}
