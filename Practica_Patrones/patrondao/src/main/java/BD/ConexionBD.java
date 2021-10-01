package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	public static Connection con = null;
	
	private static final String conURrl = "jdbc:mariadb://localhost:3336/classicmodels?user=root&password=root"
			+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public static Connection getConnection() {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection(ConexionBD.conURrl);
				
				System.out.println("Conexion exitosa");
			
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("NOP");
		}
		
		return con;
		
	}
	
	public static void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
