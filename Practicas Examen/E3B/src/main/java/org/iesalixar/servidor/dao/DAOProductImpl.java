package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Product;

public class DAOProductImpl implements DAOProduct {

	@Override
	public ArrayList<Product> getProduct(String productName) {
		ArrayList<Product> productList = new ArrayList<Product>();

		Product product;
		Connection con = null;

		try {

			String sql = "select * from products where productName LIKE ? OR productLine LIKE ?";
			
			PoolDB pool = new PoolDB();

			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

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

			con.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return productList;

	}

	@Override
	public Product getProducts(String productCode) {
		Product product = null;
		Connection con = null;

		try {

			String sql = "select * from products where productCode=?";
			
			PoolDB pool = new PoolDB();

			con = pool.getConnection();
			
			PreparedStatement statement = con.prepareStatement(sql);

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
			try {
            	con.close();
            } catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return product;
	}
	
	@Override
	public List<Product> getAllProducts() {
		ArrayList <Product> productList = new ArrayList<>();
        Product product;
        Connection con = null;

        try {
            String sql = "select * from products";
            
            PoolDB pool = new PoolDB();

			con = pool.getConnection();
			
            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            
           

            while (rs.next()) {

                product = new Product();

                product.setProductName(rs.getString("productName"));
                product.setProductCode(rs.getString("productCode"));
                product.setProductLine(rs.getString("productLine"));
                product.setQuantityInStock(rs.getInt("quantityInStock"));
                product.setBuyPrice(rs.getDouble("buyPrice"));
                
                productList.add(product);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
            	con.close();
            } catch (Exception e) {
				System.out.println(e.getMessage());
			}
        }

        return productList;
	}

	@Override
	public boolean updateProduct(Product product) {
		
		Connection con = null;
		int resultado = 0;
		
		try {
			
			PoolDB pool = new PoolDB();
			String sql = "update products set quantityInStock= ?, buyPrice= ? where productCode= ?";
			
			con = pool.getConnection();
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, product.getQuantityInStock());
			statement.setDouble(2, product.getBuyPrice());
			statement.setString(3, product.getProductCode());
			
			ResultSet rs = statement.executeQuery();
			
			con.close();
			
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		
		return (resultado == 0 ? false:true);
	}

}
