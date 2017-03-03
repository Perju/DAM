package pruebas;

import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido {

	private InputStream path;

	public Sonido(String path){
		this.path = Prueba004.class.getResourceAsStream(path); 
	}

	public void reproducirSonido(int tiempo) throws InterruptedException{
		try
		{
			Clip sonido = AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(this.path));
			sonido.start();
		}
		catch(Exception fallo)
		{
			System.out.println(fallo);
		}
		Thread.sleep(tiempo);
	}
}
