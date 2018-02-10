package Sockets.Chat_Servidor;
import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JFrame;

public class ServidorChat extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	static ServerSocket socketServidor;
	static final int PUERTO = 44444;
	static int CONEXIONES = 0;
	static int ACTUALES = 0;
	static int MAXIMO=10;
	static boolean repetir=true;
	
	static JTextField mensaje = new JTextField("");
	static JTextField mensaje2 = new JTextField("");
	private JScrollPane scrollpanel;
	static JTextArea txtAreaChat;
	JButton btnSalir = new JButton("Salir");
	static HashSet<Socket> tabla;//almacena sockets de clientes
	
	public ServidorChat() {
		super("SERVIDOR MiCHAT");
		setLayout(null);
		mensaje.setBounds(10,10,400,30);
		add(mensaje);mensaje.setEditable(false);
		
		mensaje2.setBounds(10,348,400,30);
		add(mensaje2);mensaje2.setEditable(false);
		
		txtAreaChat = new JTextArea();
		scrollpanel = new JScrollPane(txtAreaChat);
		scrollpanel.setBounds(10,50,400,300);
		add(scrollpanel);
		
		btnSalir.setBounds(420, 10, 100, 30);
		add(btnSalir);
		
		txtAreaChat.setEditable(false);
		btnSalir.addActionListener(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		tabla = new HashSet<Socket>();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == btnSalir) {
			try {
				repetir=false;
				socketServidor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
	}
	
	public static void main(String[] args) throws IOException {
		socketServidor = new ServerSocket(PUERTO);
		System.out.println("Servidor iniciado...");
		ServidorChat pantalla = new ServidorChat();
		pantalla.setBounds(0,0,540,400);
		pantalla.setVisible(true);
		mensaje.setText("NUMERO DE CONEXION ACTUALES: " + 0);
		//se admiten hasta 10 conexiones
		while(repetir) {
			Socket s = new Socket();
			try {
				s=socketServidor.accept();// esperando al cliente
			}catch (SocketException e) {
				break;// sale del bucle si pulsamos el boton salir
			}
			CONEXIONES++;
			
			if (ACTUALES < MAXIMO) {
				tabla.add(s); // almacenar socket
				ACTUALES++;
				HiloServidor hilo = new HiloServidor(s);
				hilo.start();// lanzar hilo
			}
		}//fin while
		if(!socketServidor.isClosed()) {
			try {
				mensaje2.setForeground(Color.red);
				mensaje2.setText("MAXIMO Nº DE CONEXIONES ESTABLECIDAS: "+ CONEXIONES);
				socketServidor.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Servidor finalizado");
	}
}