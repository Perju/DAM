package pruebas;
// imports necesarios
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SonidoJavaIO {
	// Una clase que te usa string para usarlo como ruta del archivo que queremos cargar como un stream de bits
	private InputStream path;

	public SonidoJavaIO(String path){
		// hay que usar el getResource de la clase principal
		// usando el .class. para poder acceder los metodos heredados de java, del objeto en ejecución.
		this.path = MainClass.class.getResourceAsStream(path);
	}

	public void reproducirSonido(int tiempo) throws InterruptedException{
		// capturamos excepciones
		try
		{
			// Obtenemos un clip de sonido del sistema
			Clip sonido = AudioSystem.getClip();
			// Cargamos el archivo como un stream de bits
			sonido.open(AudioSystem.getAudioInputStream(this.path));
			sonido.start();
		}
		catch(Exception fallo)
		{
			System.out.println(fallo);
		}
		// para esperar el tiempo necesario hasta que se reproduzca el sonido en milisegundos.
		// esta excepcion no se captura ya que solo se produce en aplicaciones con varios hilos de ejecución
		Thread.sleep(tiempo);
	}
}
