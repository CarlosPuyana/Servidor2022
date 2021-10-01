package packag;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PresidenteSingleton presidente = PresidenteSingleton.getPresidente("Donald", "Sanchez", 2021);
		PresidenteSingleton presidente2 = PresidenteSingleton.getPresidente("Donald", "Rajoy", 2021);
		
		System.out.println(presidente);
		System.out.println(presidente2); // Prueba para ver si funciona

	}

}
