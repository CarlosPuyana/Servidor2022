package packag;

public class PresidenteSingleton {

	private String nombre, apellidos;
	private int anoEleccion;
	
	
	private static PresidenteSingleton miPresidente; 
	
	public static PresidenteSingleton getPresidente(String nombre, String apellidos, int anoEleccion) {
		
		if (miPresidente == null) {
			miPresidente = new PresidenteSingleton(nombre, apellidos, anoEleccion);
		}
		
		return miPresidente;
		
	}
	
	private PresidenteSingleton (String nombre, String apellidos, int anoEleccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.anoEleccion = anoEleccion;
	}

	@Override
	public String toString() {
		return "PresidenteSingleton [nombre=" + nombre + ", apellidos=" + apellidos + ", anoEleccion=" + anoEleccion
				+ "]";
	}
	
	
	
	
}
