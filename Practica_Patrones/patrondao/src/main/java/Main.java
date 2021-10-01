
import BD.ConexionBD;
import DAO.PaymentDAO;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------");
		System.out.println("LISTA DE EMPLEADOS");
		System.out.println(PaymentDAO.getPayments());
		System.out.println("-----------------------------");

		
		ConexionBD.close();
	}
}
