package packag;

public class Circulo extends Figura {

	public Circulo(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String dibujarFigura() {
		// TODO Auto-generated method stub
		return "Circulo • " + getColor();
	}

}
