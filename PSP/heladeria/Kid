package heladeria;

import java.util.Random;

public class Kid extends Thread {

	//nombre del niño/a
	private String nombre;
	// heladeria a la que acude
	private Heladeria heladeria;
	// cantidad de helados comidos
	private int cantidad;
	// glotoneria es lo rapido que come 
	// velocidad para el ejercicio rnd(8)+3 == (0..7)+3 == 3..10
	private int glotoneria;
	
	Random rnd;

	public Kid(String nombre,Heladeria heladeria){
		this.nombre=nombre;
		this.heladeria=heladeria;
		this.cantidad=0;
		rnd = new Random();
		// si calculo aqui la glotoneria, se pueden desequilibrar mucho
		this.glotoneria=rnd.nextInt(8)+3;
	}

	@Override
	public void run() {
		while(heladeria.isActivo()){
			try {
				heladeria.heladeroCogeHelado();
				cantidad++;
				System.out.println("El chico/a "+this.nombre+" coge un helado");
				heladeria.heladeroEntregaHelado();
				// si calculo aqui la glotoneria se equilibran en consumo
				Thread.sleep(glotoneria);
			} catch (InterruptedException ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
	
	public String toString(){
		return "El chico/a "+this.nombre+" se ha comido "+cantidad+" helados";
	}

}
