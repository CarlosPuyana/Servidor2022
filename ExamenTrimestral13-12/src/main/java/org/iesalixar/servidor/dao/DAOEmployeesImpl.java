package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Employees;

public class DAOEmployeesImpl implements DAOEmployees{

	@Override
	public ArrayList<Employees> getAllEmployees() {
		
		ArrayList<Employees> employeesList = new ArrayList<>();
		Connection con = null;

		try {

			String sql = "select e.employeeNumber,e.lastName, e.firstName , e.extension, e.jobTitle ,o.city, CONCAT(e2.firstName,\" \" ,e2.lastName) as jefe from employees e inner join offices o ON e.officeCode = o.officeCode INNER JOIN employees e2 ON e.reportsTo = e2.employeeNumber";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Employees employee = new Employees();

				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				employee.setOfficeCode(rs.getString("city"));
				employee.setJefe(rs.getString("jefe"));
				employee.setJobTitle(rs.getString("jobTitle"));
				
				employeesList.add(employee);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return employeesList;
		
	}

	@Override
	public boolean insertEmployee(Employees employee) {
		int resultado=0;
		Connection con = null;
		
		try {

			String sql = "insert into employees values(?,?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, employee.getEmployeeNumber());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getFirstName());
			statement.setString(4, employee.getExtension());
			statement.setString(5, "aaa@aa.com");
			statement.setString(6, employee.getOfficeCode());
			statement.setInt(7, employee.getReportsTo());
			statement.setString(8, employee.getJobTitle());

			resultado = statement.executeUpdate();


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		return (resultado==0?false:true);
	}

	@Override
	public ArrayList<Employees> getAllJefes() {
		ArrayList<Employees> employeesList = new ArrayList<>();
		Connection con = null;

		try {

			String sql = "	select CONCAT(firstName, \" \", lastName) as nombre from employees";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Employees employee = new Employees();

				employee.setJefe(rs.getString("nombre"));
				
				employeesList.add(employee);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return employeesList;
	}

	@Override
	public Employees getEmpleado(String nombre) {
		Connection con = null;
		Employees employee = null;

		try {

			String sql = "	select * from employees where firstName LIKE ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				employee = new Employees();
				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				employee.setOfficeCode(rs.getString("city"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));
				
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return employee;
	}

}
