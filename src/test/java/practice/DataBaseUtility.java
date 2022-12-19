package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility 
{
	Driver dbdriver;
	public void getDataFromDatabase(String dbloc,String pw,String un,String query)
	{
		try {
			dbdriver=new Driver();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	try {
		DriverManager.registerDriver(dbdriver);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	try {
		connection = DriverManager.getConnection(dbloc,pw,un);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	Statement statement = null;
	try {
		statement = connection.createStatement();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	try {
		ResultSet result = statement.executeQuery(query);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
}
