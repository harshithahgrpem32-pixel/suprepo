package genericUtility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Databaseutilities {
	Connection con;
	//connect to db
	public void getDBConnection()
	{
		try {
	      com.mysql.jdbc.Driver	driverref	=new com.mysql.jdbc.Driver();
	      DriverManager.registerDriver(driverref);
	      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	//close db
	public void closeDBConnection()
	{
		try {
			con.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	
	//execute
	public ResultSet executeConSelectQuery(String query)
	{
		ResultSet results=null;
		try {
			Statement stat=con.createStatement();
			results=stat.executeQuery(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		} 
		return results;
	}
	
	//executenonselect
	public int executeNonSelectQuery(String query)
	{
		int result=0;
		try {
			Statement stat=con.createStatement();
			result=stat.executeUpdate(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
}
