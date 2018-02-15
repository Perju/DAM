package Sockets.Chat_Cliente;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class ClienteChat extends JFrame implements ActionListener, Runnable {
	
	private static final long serialVersionUID = 1L;
	Socket socket = null;
	// steams
	BufferedReader entrada;
	PrintWriter salida;
	String nombre;
	static JTextField mensaje = new JTextField();
	private JScrollPane scrollpanel;
	static JTextArea txtAreaChat;
	JButton btnEnviar = new JButton("Enviar");
	JButton btnSalir = new JButton("Salir");
	boolean repetir = true;

	// constructor
	public ClienteChat(Socket s, String nombre) {
		super("MiCHAT Usuraio: " + nombre);
		
		setLayout(null);
		mensaje.setBounds(10, 10, 400, 30);			add(mensaje) ;
		txtAreaChat = new JTextArea();
		// El scrollpanel seguira a txtAreaChat para ver los mensajes nuevos
		((DefaultCaret)txtAreaChat.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		scrollpanel = new JScrollPane (txtAreaChat);
		scrollpanel.setBounds(10, 50, 400, 300);	add(scrollpanel);
		btnEnviar.setBounds(420, 10, 100, 30);		add(btnEnviar);
		btnSalir.setBounds(420, 50, 100, 30);		add(btnSalir);
		txtAreaChat.setEditable(false);
		btnEnviar.addActionListener(this);
		btnSalir.addActionListener(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		socket = s;
		this.nombre = nombre;

		try {// abrimos los streams del socket pasado al constructor
			entrada =new BufferedReader( 
					new InputStreamReader(socket.getInputStream()));
			salida = new PrintWriter(socket.getOutputStream (), true);
			String texto = " > Entra en el Chat ... " + nombre;
			salida.println(texto); //escribe mensaje de entrada
		} catch (IOException e) {
			System.out.println("ERROR DE E/S");
			e.printStackTrace();
			System.exit(0);
		}
	}// fin constructor

	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource()==btnEnviar) {// se pulsa el boton enviar
			String texto = nombre + "> "+mensaje.getText();
			mensaje.setText("");// limpio el area de mensaje
			// enviamos el mensaje por el stream de salida
			try {salida.println(texto);} 
			catch (Exception e) {e.printStackTrace();}
		}
		if(evento.getSource()==btnSalir) {// se pulsa el boton salir
			String texto = " > Abandona el Chat ... " + nombre;
			try {
				salida.println(texto);
				salida.println("*");
				repetir = false;// para salir del bucle
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}// action performed

	@Override
	public void run() {
		String linea = "";
		while(repetir) {
			try {
				linea=entrada.readLine();
				txtAreaChat.append(linea+"\n");
			}catch (Exception e) {
				JOptionPane.showMessageDialog(
						null, "IMPOSIBLE CONECTAR CON EL SERVIDOR\n"+ e.getMessage(),
						"<<MENSAJE DE ERROR:2>>", JOptionPane.ERROR_MESSAGE);
				repetir = false;
			}
		}// while
		try {
			socket.close();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//run

	public static void main(String[] args) {
		int puerto = 44444;
		String host = JOptionPane.showInputDialog(
				"Introduce el servidor");
		String nombre = JOptionPane.showInputDialog(
				"Introduce tu Nick");
		Socket s = null;
		try {
			s = new Socket(host, puerto);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(
					null,"IMPOSIBLE CONECTAR CON EL SERVIDOR\n"+e.getMessage(),
					"<<MENSAJE DE ERROR:1>>", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}// try-catch
		if(!nombre.trim().equals("")) {//hay que escribir algo
			ClienteChat cliente = new ClienteChat(s, nombre);
			cliente.setBounds(0,0,540,400);
			cliente.setVisible(true);
			new Thread(cliente).start();
		}else {
			System.out.println("El nombre esta vacio....");
		}
	}//main

}