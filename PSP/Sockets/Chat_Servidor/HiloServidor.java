package Sockets.Chat_Servidor;
import java.io.*;
import java.net.*;

public class HiloServidor extends Thread {

	BufferedReader entrada;
	Socket socket = null;
	
	public HiloServidor(Socket s) throws IOException {//CONSTRUCTOR
		socket = s;
		//se crea el flujo de entrada
		entrada = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
	}//..
	
	public void run() {//tarea a realizar con el cliente
		ServidorChat.mensaje.setText("NUMERO DE CONEXIONES ACTUALES: "
				+ ServidorChat.ACTUALES);
		String cadena = "Bienvenido al servidor";
		enviarMensajes(cadena);
		
		while(true) {
			cadena = "*";
			try {
				cadena = entrada.readLine();
				// cuando un cliente finaliza envia un *
				if(cadena.trim().equals("*")) {
					ServidorChat.ACTUALES--;
					ServidorChat.mensaje.setText("NUMERO DE CONEXIONES ACTUALES: "
							+ ServidorChat.ACTUALES);
					// sacar el socket de la tabla
					ServidorChat.tabla.remove(socket);
					break;//salir del bucle while
				}
				ServidorChat.txtAreaChat.append(cadena + "\n");
				enviarMensajes(cadena); // envio texto a todos los clientes
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}//fin while
	}//run
	
	private void enviarMensajes(String texto) {
		// recorremos la tabla de sockets para enviarles los mensajes
		for(Socket s1 : ServidorChat.tabla) {
			try {
				PrintWriter salida = new PrintWriter(s1.getOutputStream(),true);
				salida.println(texto);
			} catch (SocketException e) {
				// cuando escribimos en un socket de un 
				// cliente que ha finalizado
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

















/// espacio para subir el texto hacia arriba mientras trabajo