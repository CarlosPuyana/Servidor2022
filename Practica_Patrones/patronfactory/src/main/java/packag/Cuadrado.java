package packag;

public class Cuadrado extends Figura {

	public Cuadrado(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String dibujarFigura() {
		// TODO Auto-generated method stub
		return "Cuadrado ⊡ " + getColor();
	}
	
}
