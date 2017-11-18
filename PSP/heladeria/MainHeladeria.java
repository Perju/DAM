package heladeria;

import java.util.concurrent.Semaphore;

public class MainHeladeria {

	public static void main(String[] args) {
		// 5 nombres
		String kidNames[]={"Roci","Javi","Juli","Toni","Yoli"};
		// creamos la heladeria
		Heladeria heladeria = new Heladeria();
		// creamos la turba
		Kid turba[]=new Kid[5];
		// Le damos nombre a los niños de la turba
		for(int i = 0; i<kidNames.length; i++){
			turba[i]=new Kid(kidNames[i],heladeria);
			turba[i].start();
		}
		while(heladeria.isActivo()){
			try { 
				Thread.sleep(200);
			} 
			catch (InterruptedException e) { 
				e.printStackTrace(); 
			}
		}
		
		//mostramos los helados que se come cada crio
		for(int i =0; i< turba.length;i++){
			System.out.println(turba[i]);
		}
		System.out.println();
	}
}
