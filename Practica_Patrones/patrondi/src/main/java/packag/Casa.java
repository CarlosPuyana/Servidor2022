package packag;

public class Casa {

	private double area;
	private Tejado tejado;
	private Pared pared1, pared2, pared3, pared4;
	
	public Casa(double area, Tejado tejado, Pared pared1, Pared pared2, Pared pared3, Pared pared4) {
		
		this.area = area;
		this.tejado = tejado;
		this.pared1 = pared1;
		this.pared2 = pared2;
		this.pared3 = pared3;
		this.pared4 = pared4;
	}

	@Override
	public String toString() {
		return "Casa [area=" + area + ", tejado=" + tejado + ", pared1=" + pared1.toString()  + ", pared2=" + pared2.toString()  + ", pared3="
				+ pared3.toString()  + ", pared4=" + pared4.toString()  + "]";
	}
	
	
	
	
}
