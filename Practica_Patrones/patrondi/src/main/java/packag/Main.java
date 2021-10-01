package packag;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tejado t1 = new Tejado();
		Pared p1 = new Pared(3);
		Pared p2 = new Pared(3);
		Pared p3 = new Pared(3);
		Pared p4 = new Pared(3);
		TejadoTejas teja1 = new TejadoTejas();
		
		Casa casa = new Casa(182, t1, p1, p2, p3, p4);
		
		System.out.println("Casa N1 : " + casa.toString());
		
		t1.darSoporte();
		
		
		Tejado t2 = new Tejado();
		Pared p5 = new Pared(3);
		Pared p6 = new Pared(3);
		Pared p7 = new Pared(3);
		Pared p8 = new Pared(3);
		TejadoTejas teja2 = new TejadoTejas();
		
		Casa casa2 = new Casa(1802, t2, p5, p6, p7, p8);
		
		System.out.println("Casa N2 : " + casa2.toString());
		
		teja2.darSoporte();
		

	}

}
