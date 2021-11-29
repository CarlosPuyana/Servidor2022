package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Product;

public class DAOProductImpl implements DAOProduct {

	@Override
	public ArrayList<Product> getProduct(String productName) {
		ArrayList<Product> productList = new ArrayList<Product>();

		Product product;

		try {

			String sql = "select * from products where productName LIKE ? OR productLine LIKE ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			statement.setString(1, '%' + productName + '%');
			statement.setString(2, '%' + productName + '%');

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Product();

				product.setProductCode(rs.getString("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));

				productList.add(product);

			}

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return productList;

	}

	@Override
	public Product getProducts(String productCode) {
		Product product = null;

		try {

			String sql = "select * from products where productCode=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			statement.setString(1, productCode);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Product();

				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getNString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		
		ArrayList<Product> productList = new ArrayList<>();
		Product product;
		
		
		try {
			
			String sql = "select * from products";
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				product = new Product();
				
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getNString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));
				
				productList.add(product);
				
				
			}
			
			
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Hecho");
		return productList;
	}

	@Override
	public Product getProductByCode(int code) {
		Product product = null;

		try {

			String sql = "select * from products where  productCode=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, code);

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMSRP(rs.getDouble("MSRP"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return product;


}
}

