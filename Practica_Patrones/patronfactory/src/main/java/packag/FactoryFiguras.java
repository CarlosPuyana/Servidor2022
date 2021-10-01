package packag;

public class FactoryFiguras {

	public static Figura  getFigura(String tipo, String Color) {
		if (tipo.equals("triangulo")) {
			return new Triangulo(Color);
		} else if (tipo.equals("rectangulo")) {
			return new Rectangulo(Color);
		} else if (tipo.equals("cuadrado")) {
			return new Cuadrado(Color);
		} else if (tipo.equals("circulo")){
			return new Circulo(Color);
		} else {
			return null;
		}
		
	}
	
}
