package Sockets.enviarArchivos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		ServerSocket serverSocket;
		Socket socket;
		// fichero de salida
		File fichero = new File("resources/servidor/imagen.png");

		try {
			serverSocket = new ServerSocket(15000);
			socket = serverSocket.accept();

			// abrimos el stream de entrada
			BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
			// creamos el stream de salida hacia el fichero
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(fichero));
			// 16*1024 es un buffer de 16Kb
			byte[] b = new byte[16*1024];
			int len;

			while((len=bis.read(b)) > 0) {
				bos.write(b, 0, len);
			}

			bos.close();
			bis.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}