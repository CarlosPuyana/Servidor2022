package packag;

public class Rectangulo extends Figura {

	public Rectangulo(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String dibujarFigura() {
		// TODO Auto-generated method stub
		return "Rectangulo 🀱 " + getColor();
	}

}
