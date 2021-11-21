package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Payment;

public class DAOCustomerImpl implements DAOCustomer {

	public DAOCustomerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Customer> getAllCustomers() {

		ArrayList<Customer> customerList = new ArrayList<>();
		
		try {

			String sql = "select * from customers";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Customer customer = new Customer();
				
				customer.setCustomerNumber(rs.getInt("customerNumber"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactFirstName(rs.getString("contactFirstName"));
				customer.setContactLastName(rs.getString("contactLastName"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddressLine1(rs.getString("addressLine1"));
				customer.setAddressLine2(rs.getString("addressLine2"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPostalCode(rs.getString("postalCode"));
				customer.setCountry(rs.getString("country"));
				customer.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
				customer.setCreditLimit(rs.getDouble("creditLimit"));
				
				customerList.add(customer);
			}

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return customerList;

	}

}
