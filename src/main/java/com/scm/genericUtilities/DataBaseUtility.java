package com.scm.genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * this class used store method which is used to read and write data into database
 * @author HP
 *
 */
public class DataBaseUtility 
{

	//shankar
// branch 'master' of https://github.com/havalad1/Upparel.git
	Driver dbdriver;
	/**
	 * this method used to read and write data into database
	 * @param dbloc
	 * @param pw
	 * @param un
	 * @param query
	 */
	public void getDataFromDatabase(String dbloc,String pw,String un,String query)
	{
		try {
			dbdriver=new Driver();
		} catch (SQLException e2) {
			
		}
	try {
		DriverManager.registerDriver(dbdriver);
	} catch (SQLException e) {
		
	}
	Connection connection = null;
	try {
		connection = DriverManager.getConnection(dbloc,pw,un);
	} catch (SQLException e) {
		}
	Statement statement = null;
	try {
		statement = connection.createStatement();
	} catch (SQLException e1) {
		
	}
	try {
		ResultSet result = statement.executeQuery(query);
		if(result.equals(1))
		{
			System.out.println("updated successfully");
		}
		else
		{
			System.out.println("not updated");
		}
	} catch (SQLException e) {
		
	}
	}
}
