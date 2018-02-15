package Sockets.enviarArchivos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {

		// fichero de entrada usando ruta relativa a la raiz del proyecto
		// cuelga junto a la libreria JRE system library 1.8
		File fichero = new File("resources/cliente/imagen.png");
		Socket socket;
		try {
			socket = new Socket("localhost",15000);
			// creamos un buffer de entrada con el fichero
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(fichero));
			// Obtenemos el stream de salida del socket
			BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
			// un pequeño buffer de 16Kb bytes como en el servidor
			byte[] b = new byte[16*1024];
			int len;// la longitud en bytes

			while((len=bis.read(b)) > 0) {// si leemos mas de 0 bytes
				bos.write(b, 0, len);
				// puede hacer falta limpiar el buffer para liberar el socket
				// y que la otra parte pueda usarlo para leer.
				bos.flush();
			}
			bos.close();
			bis.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
