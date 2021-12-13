package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.ProductLines;

public class DAOProductLinesImpl implements DAOProductLines {

	@Override
	public List<ProductLines> getCategorias() {
		
		ArrayList<ProductLines> categoriasList = new ArrayList<>();
		ProductLines productLines = null;
		Connection con = null;
		
		try {
			String sql = "select productLine from productlines";
			PoolDB pool = new PoolDB();

			con = pool.getConnection();
			
			PreparedStatement statement = con.prepareStatement(sql);


			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				productLines = new ProductLines();

				productLines.setProductLine(rs.getString("productLine"));

				categoriasList.add(productLines);

			}
		} catch (SQLException ex)  {
			System.out.println(ex.getMessage());
		}
		
		
		return categoriasList;
	}

}
