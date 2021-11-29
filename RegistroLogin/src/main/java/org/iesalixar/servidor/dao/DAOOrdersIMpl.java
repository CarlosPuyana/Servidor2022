package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Orders;
import org.iesalixar.servidor.model.OrdersDetails;

public class DAOOrdersIMpl implements DAOOrders {

	// Para 1 pedido en cocreto
	@Override
	public Orders getOrder(int orderNumber) {
		Orders order = null;

		try {

			String sql = "select * from orders where  orderNumber=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, orderNumber);
			

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				order = new Orders();
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setRequiredDate(rs.getString("requiredDate"));
				order.setShippedDate(rs.getString("shippedDate"));
				order.setStatus(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setCustomerNumber(rs.getInt("customerNumber"));
				
				DAOOrdersDetailsImpl daoOD = new DAOOrdersDetailsImpl();
				ArrayList<OrdersDetails> od = daoOD.getDetailsFromOrder(orderNumber);
				
				order.setOrdersDetails(od);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return order;
	}

	// Admin Todos los pedidos
	@Override
	public ArrayList<Orders> getAllOrders() {
		ArrayList<Orders> orderList = new ArrayList<>();
		Orders order = null;

		try {
			String sql = "select * from orders";

			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				order = new Orders();

				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setRequiredDate(rs.getString("requiredDate"));
				order.setShippedDate(rs.getString("shippedDate"));
				order.setStatus(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setOrderNumber(rs.getInt("customerNumber"));

				DAOOrdersDetailsImpl daoOrders = new DAOOrdersDetailsImpl();
				
				ArrayList<OrdersDetails> od = daoOrders.getDetailsFromOrder(order.getOrderNumber());

				order.setOrdersDetails(od);
				
				orderList.add(order);

			}

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return orderList;
	}

}
