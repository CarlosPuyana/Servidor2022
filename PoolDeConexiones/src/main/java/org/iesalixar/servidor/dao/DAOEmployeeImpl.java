package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Employee;
import org.iesalixar.servidor.model.Offices;

public class DAOEmployeeImpl implements DAOEmployee {

	@Override
	public ArrayList<Employee> getAllEmployeesFromOffice(String officeCode) {
		ArrayList<Employee> employeeList = new ArrayList<>();
		
		Employee empleado = null;
		Connection con = null;

        try {

            String sql = "select * from employees where officeCode= ?";
            
            
            PoolDB pool = new PoolDB();
            con = pool.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, officeCode);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

            	empleado = new Employee();

            	empleado.setEmployeeNumber(rs.getInt("employeeNumber"));
                empleado.setLastName(rs.getString("lastName"));
                empleado.setFirstName(rs.getString("firstName"));
                empleado.setExtension(rs.getString("extension"));
                empleado.setEmail(rs.getString("email"));
                empleado.setOfficeCode(rs.getString("officeCode"));
                empleado.setReportsTo(rs.getInt("reportsTo"));
                empleado.setJobTitle(rs.getString("jobTitle"));

                employeeList.add(empleado);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }

        return employeeList;
	
	}

}
