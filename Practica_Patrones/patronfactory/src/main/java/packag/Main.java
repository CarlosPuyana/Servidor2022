package packag;

public class Main {

	public static void main(String[] args) {
		
		Figura f = FactoryFiguras.getFigura("triangulo", "azul");
		Figura f2 = FactoryFiguras.getFigura("rectangulo", "amarillo");
		Figura f3 = FactoryFiguras.getFigura("cuadrado", "verde");
		Figura f4 = FactoryFiguras.getFigura("circulo", "morado");
		
		System.out.println(f.dibujarFigura());
		System.out.println(f2.dibujarFigura());
		System.out.println(f3.dibujarFigura());
		System.out.println(f4.dibujarFigura());

	}

}
