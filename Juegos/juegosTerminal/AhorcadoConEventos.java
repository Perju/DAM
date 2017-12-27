/* El juego del ahorcado pero esta vez
 * hecho con eventos y otras cosas
 * 
 * Basado en el juego del curso
 * Introduccion a la programacion de videojuegos
 * de Nacho Cabanes
 * http://www.nachocabanes.com/videojuegos/ipj/ipj05.php
 * * * * * * * * * * * * * * * * * * * * * * * * * * * */
package juegosTerminal;
//importamos las librerias necesarias
import java.applet.Applet;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Random;
/*
 * nuestra clase hereda de Applet para poder crear ventanitas y hacer dibujitos
 * e implementa KeyListener, imagino para leer eventos del teclado
 * y poder crear un bucle que se ejecuta y no hace pausas para leer el teclado
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
public class AhorcadoConEventos extends Applet implements KeyListener{
	// serial version para la clase serializable
	private static final long serialVersionUID = 1L;
	// pasamos de la palabra reservada final parece ser para CONSTANTES
	int NUMPALABRAS = 10;
	int MAXINTENTOS = 5;

	String palabra;			// La palabra a adivinar
	StringBuffer intento;	// Lo que el jugador va consiguiendo
	String letras="";		// Las letras que se han probado

	int oportunidades;		// El numero de intentos permitidos
	char letra;				// Cada letra que prueba el jugador
	int i;					// Para mirar cada letra con "for"
	boolean acertado;		// Si ha acertado alguna letra
	boolean terminado;		// Si la partida ha terminado

	// nuestras cosas de clase

	Random rnd = new Random();

	String palabras[]={
			"Alicante","Barcelona","Guadalajara","Madrid",
			"Toledo","Malaga","Zaragoza","Sevilla",
			"Valencia","Valladolid"
	};
	// fallo a fallo vamos dibujando el moñaco
	void PrimerFallo(Graphics g){
		//dibujamos la plataforma
		g.setColor(Color.cyan);
		g.drawLine(20, 180, 120, 180);
	}
	void SegundoFallo(Graphics g){
		//dibujamos el palo
		g.drawLine(100,180,100,125);
	}
	void TercerFallo(Graphics g){
		//dibujamos el otro palo
		g.drawLine(100, 125, 70, 125);
	}
	void CuartoFallo(Graphics g){
		// dibujamos la cuerda
		g.drawLine(70, 125, 70, 130);
	}
	void QuintoFallo(Graphics g){
		// dibujamos el moñaco
		// Cabeza
		g.setColor(Color.yellow);
		g.drawOval(62, 130, 16, 16);
		// Tronco
		g.drawLine(70, 146,   70, 160);
		// Brazos
		g.drawLine(50, 150,  90, 150);
		// Piernas
		g.drawLine(70, 160,   60, 175);
		g.drawLine(70, 160,   80, 175);
	}

	// para dar valores iniciales
	public void init(){
		i = rnd.nextInt(10)+1;
		palabra=palabras[i];
		oportunidades=MAXINTENTOS;

		// rellenamos con *
		intento=new StringBuffer(palabra);

		for(i=0;i<palabra.length();i++){
			if(palabra.charAt(i)==' '){
				intento.setCharAt(i, ' ');
			}else{
				intento.setCharAt(i, '*');
			}
		}
		terminado = false;
		requestFocus();
		addKeyListener(this);
	}

	// funcion para decidir cuando se dibujan las cosas
	public void paint(Graphics g){
		//fondo negro
		g.setColor(Color.black);
		g.fillRect(0, 0, 639, 479);

		// pinto los intentos restantes
		g.setColor(Color.white);
		g.drawString("Te quedan: "+ oportunidades +" intentos", 20, 45);

		// Le muestro como va
		g.drawString(intento.toString(),80, 32);

		// Muestro las letras probadas
		g.setColor(Color.yellow);
		g.drawString("Letras intentadas:" + letras, 20, 72);

		// Y le pido otra letra
		g.drawString("Que letra?", 20, 60);

		// Dibujo lo que corresponde del "patibulo"
		if (oportunidades <= 4) PrimerFallo(g);
		if (oportunidades <= 3) SegundoFallo(g);
		if (oportunidades <= 2) TercerFallo(g);
		if (oportunidades <= 1) CuartoFallo(g);
		// Si se acabo: Le felicito o le digo cual era
		if ((oportunidades <= 0) || (palabra.equals(intento.toString()))) {
			terminado = true;
			if ( palabra.equals(intento.toString()) ){
				g.drawString("Acertaste!", 20, 100);
			}else{
				g.drawString("Lo siento.  Era: " + palabra, 20, 100);
				QuintoFallo(g);
			}
		}
	}
	// @overrides creados automaticamente por eclipse al implementar KeyListener
	@Override
	public void keyPressed(KeyEvent e) {	
	}

	@Override
	public void keyReleased(KeyEvent e) {	
	}

	@Override
	public void keyTyped(KeyEvent e) {	
		//comprobamos el estado del teclado
		letra=e.getKeyChar();
		if (! terminado) {
			letras=letras+letra;

			acertado = false;      // Miro a ver si ha acertado
			for (i=1; i<=palabra.length(); i++)
				if (Character.toLowerCase(letra) == Character.toLowerCase(palabra.charAt(i-1))){
					intento.setCharAt(i-1, palabra.charAt(i-1) );
					acertado = true;
				}

			if ( ! acertado ){     // Si falla, le queda un intento menos
				oportunidades --;
			}
		}
		repaint();
		e.consume();
	}
}
