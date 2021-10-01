package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import BD.ConexionBD;

public class PaymentDAO {

	public static List<Payment> getPayments() {
	
	Connection con = ConexionBD.getConnection();
	ArrayList<Payment> lista_payments = new ArrayList<Payment>();
	
	try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from payments");
		
		while (rs.next()) {
			Payment p = new Payment(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDouble(4));
		lista_payments.add(p);
		}
		
		
	} catch (SQLException throwables) {
		throwables.printStackTrace();
	}
	
	return lista_payments;
	
}
	
	public static boolean searchPayments(int Buscador) {
		
		boolean existe = false;
		Connection con = ConexionBD.getConnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select customerNumber from payments");
			
			while (rs.next()) {
				
				if (rs.getInt(1) == Buscador) {
					existe = true;
				}
				else createPayments(Buscador);
				
			}
			
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		
		return existe;
	}

	private static void createPayments(int buscador) {
		Connection con = ConexionBD.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO payments VALUES (?, ?, ?, ?)");
			
			String checkNumber = "HQ1020"; String paymentDate = "2004-10-19";
			double amount = 6660.3;
			
			ps.setInt(1, buscador);
			ps.setString(2, checkNumber);
			ps.setString(2, paymentDate);
			ps.setDouble(2, amount);
			
			ps.execute();
			

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		 
	}
	
}
