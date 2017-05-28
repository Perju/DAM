package almacenarObjetoSpinner;

import java.io.*;

public class Spinner implements Comparable,Serializable{
	/**
	 * para serializar el objeto y guardarlo en un archivo
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private int rodamientos;
	private int durabilidad;

	public Spinner(String nombre, int rodamientos, int durabilidad) {
		this.nombre = nombre;
		this.rodamientos = rodamientos;
		this.durabilidad = durabilidad;
	}//constructor

	@Override
	public String toString() {
		return "Spinner nombre: " + nombre + " rodamientos: " + rodamientos + " durabilidad: " + durabilidad;
	}//ToString

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		/*if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;*/
		Spinner other = (Spinner) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object obj) {
		if (this == obj){
			return 0;
		}
		Spinner other = (Spinner) obj;
		if(this.durabilidad==(other.durabilidad)){
			return nombre.compareTo(other.nombre);
		}else{
			return this.durabilidad-other.durabilidad;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRodamientos() {
		return rodamientos;
	}

	public void setRodamientos(int rodamientos) {
		this.rodamientos = rodamientos;
	}

	public int getDurabilidad() {
		return durabilidad;
	}

	public void setDurabilidad(int durabilidad) {
		this.durabilidad = durabilidad;
	}
}

