package Sockets.TCP_Ejemplo;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		try (ServerSocket servidor = new ServerSocket(4441);
				Socket socket = servidor.accept();
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);)
		{// mira que cuatro objetos me olvido de cerrar "servidor", "socket", "is" y "dis"
			String dato=dis.readUTF();
			while (!dato.equals("salir")) {
				System.out.println(dato);
				dato=dis.readUTF();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}