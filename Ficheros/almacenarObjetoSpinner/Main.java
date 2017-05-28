package almacenarObjetoSpinner;
import java.util.*;

public class Main {
	
	public static boolean buscarNombre(TreeMap<Integer, TreeSet<Spinner> > mapSpinner, Spinner spin){
		Iterator< Map.Entry<Integer, TreeSet<Spinner>> > it ;
		it = mapSpinner.entrySet().iterator();
		Map.Entry<Integer, TreeSet<Spinner>> mEntry; // referencia que apuntara a un nodo de mapNotas

		TreeSet<Spinner> listanNombreDelNodo=null;

		boolean encontrado=false; // de momento no he encontrado el apellido
		while (it.hasNext() && !encontrado) { // recorre las listas de apellidos de cada nodo
			//obtenemos un nodo de mapNotas: nota  +  lista de apellidos
			mEntry = it.next(); // apuntamos al siguiente nodo
			//obtenemos la lista de apellidos asociados a la nota
			listanNombreDelNodo = mEntry.getValue(); 

			if(listanNombreDelNodo.contains(spin)){
				encontrado=true;
			}
		}
		return encontrado;
	}
	
	public static void insertarSpinner(TreeMap<Integer, TreeSet<Spinner> > mapSpinner,Spinner spin){
		TreeSet<Spinner> t1;
		if (buscarNombre(mapSpinner,spin)) {
			System.out.println("Ya existe el Spinner");
		}else {
			if (mapSpinner.containsKey(spin.getRodamientos())) {
				t1=mapSpinner.get(spin.getRodamientos());
				t1.add(spin);
				mapSpinner.put(spin.getRodamientos(),t1);
			}else{
				t1=new TreeSet<Spinner>();
				t1.add(spin);
				mapSpinner.put(spin.getRodamientos(), t1);
			}
		}
	}

	public static void borrarSpinner(TreeMap<Integer, TreeSet<Spinner> > mapSpinner, Spinner spin){

		Iterator< Map.Entry<Integer, TreeSet<Spinner>> > it ;
		it = mapSpinner.entrySet().iterator();
		Map.Entry<Integer, TreeSet<Spinner>> mEntry;
		TreeSet<Spinner> t1;

		if (buscarNombre(mapSpinner,spin)) {
			
			while (it.hasNext()) {
				mEntry=it.next();
				t1=mEntry.getValue();
				if (t1.remove(spin)) {
					System.out.println("se ha borrado el Spinner");				
				}	
			}
		}//if
	}

	public static void mostrarPorRodamientos(TreeMap<Integer, TreeSet<Spinner> > mapSpinner, int rodamientos){
		
		Iterator< Map.Entry<Integer, TreeSet<Spinner>> > it ;
		it = mapSpinner.entrySet().iterator();
		Map.Entry<Integer, TreeSet<Spinner>> mEntry;
		TreeSet<Spinner> t1;
		
		while (it.hasNext()) {
			mEntry=it.next();
			if (mEntry.getKey()==rodamientos) {
				t1=mEntry.getValue();
				for(Spinner c:t1){
				System.out.println(c);
				}	
			}
		}
	}

	public static void main(String[] args) {

		TreeMap<Integer,TreeSet<Spinner>> Treemap=new TreeMap<Integer,TreeSet<Spinner>>();
		
		Random rnd=new Random();
		Spinner spin;
		String[]  nombres={"AP","MO","CO","TA","CA","PU"};
		String nombrespiner;// se concatenaran dos silabas del array String[] nombres
		int durabilidad;
		int rodamientos;
		
		//Rellenamos los variabls con numeros aleatorios		
		System.out.println("Se insertan estos spinners");
		for (int i = 0; i < 10; i++) {
			nombrespiner = nombres[rnd.nextInt(6)] + nombres[rnd.nextInt(6)];
			durabilidad = rnd.nextInt(10)+1;//[0-9]+1==[1-10]
			rodamientos = rnd.nextInt(7)+1;//[0-7]+1==[1-7]

			spin=new Spinner(nombrespiner,rodamientos,durabilidad);
			insertarSpinner(Treemap, spin);
			System.out.print(spin+"   ");
		}//for
		System.out.println();
			mostrarPorRodamientos(Treemap, 4);
	}
}