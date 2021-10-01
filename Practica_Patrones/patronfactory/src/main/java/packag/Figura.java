package packag;

public abstract class Figura {
	
	private String Color;

	public Figura(String color) {
		super();
		setColor(color);
	}
	
	public abstract String dibujarFigura();

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}
	
	
}
