package Sockets.TCP_Ejemplo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		try (Socket socketCliente = new Socket("localhost",4441);
				DataOutputStream dos = new DataOutputStream(socketCliente.getOutputStream());)
		{// los recursos metidos a lo "try(recursos)" se cierran solos
			for(int i = 0; i<10 ; i++) {
				dos.writeUTF("Linea numero: "+(i+1));
			}
			dos.writeUTF("salir");
		} catch (IOException e) {e.printStackTrace();}
	}
}
