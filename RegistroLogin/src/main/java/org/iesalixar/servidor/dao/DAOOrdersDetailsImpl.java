package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.OrdersDetails;
import org.iesalixar.servidor.model.Product;

public class DAOOrdersDetailsImpl implements DAOOrdersDetails {

	@Override
	public ArrayList<OrdersDetails> getDetailsFromOrder(int orderNumber) {
		ArrayList<OrdersDetails> orderdetails = new ArrayList<OrdersDetails>();
		OrdersDetails od = null;
		Product product = null;

		try {

			String sql = "select * from orderdetails where  orderNumber = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, orderNumber);
			

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				
				od = new OrdersDetails();
				od.setOrderLineNumber(rs.getInt("orderLineNumber"));
				od.setPriceEach(rs.getDouble("priceEach"));
				od.setQuantityOrdered(rs.getInt("quantityOrdered"));
				
				String productCode = rs.getString("productCode");
				
				DAOProductImpl daoProduct = new DAOProductImpl();
				
				
				product =daoProduct.getProductByCode(orderNumber);
				
				od.setProduct(product);
				
				orderdetails.add(od);
				

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return orderdetails;


}
}
