package paquete;
import java.io.File;
import java.io.IOException;
//imports necesarios
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SonidoJavaIO {
	// nada de clases raras, una cadena y ya vale
	private String pathStr;
	// un objeto de clase Clip para obtener el Clip del sistema
	private Clip sonido;

	public SonidoJavaIO(String path){
		// hay que usar el getResource de la clase principal
		// nos olvidamos del getResource
		this.pathStr = path;
	}

	public void reproducirSonido() throws InterruptedException{
			try {
				// obtenemos el clip de audio del sistema
				sonido = AudioSystem.getClip();
				// obtenemos el archivo de audio como un AudioInputStream
				sonido.open(AudioSystem.getAudioInputStream(new File(".\\src\\"+pathStr)));
				//AudioSystem.getAudioInputStream(new File(pathStr))
				sonido.start();
				// dividimos para 1000 y pasamos de microsegundos 1E-6 a milisegundos 1E-3
				// para esperar el tiempo que dura el sonido
				Thread.sleep((int)sonido.getMicrosecondLength()/1000); 
				// detenemos la reproduccion
				sonido.stop();
				// vaciamos el buffer
				sonido.flush();
				// cerramos el sonido, si no se vacia el buffer antes, tarda un poco en cerrar
				// y la aplicacion no corre fluida
				sonido.close();
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
