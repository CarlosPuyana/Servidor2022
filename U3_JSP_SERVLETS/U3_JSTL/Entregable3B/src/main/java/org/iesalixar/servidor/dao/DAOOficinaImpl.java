package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Oficina;

public class DAOOficinaImpl implements DAOOficina {

	@Override
	public Oficina getOficina(String city) {
		
		Oficina oficina = null;
		
		try {
			
			String sql = "select * from offices where city= ?";
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			
			statement.setString(1, city);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				oficina = new Oficina();
				oficina.setOfficeCode(rs.getString("officeCode"));
				oficina.setCity(rs.getString("city"));
				oficina.setPhone(rs.getString("phone"));
				oficina.setAddressLine1(rs.getString("addressLine1"));
				oficina.setAddressLine2(rs.getString("addressLine2"));
				oficina.setState(rs.getString("state"));
				oficina.setCountry(rs.getString("country"));
				oficina.setPostalCode(rs.getString("postalCode"));
				oficina.setTerritory(rs.getString("territory"));
				
			}
			
			ConexionBD.close();
			
			
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return oficina;
	}

}
