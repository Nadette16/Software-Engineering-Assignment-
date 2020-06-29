package Database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class databaseHandler  {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1/nadette restaurant";
	
	public Connection conn = null;
	public Statement stmt = null;
	public java.sql.PreparedStatement prep_stmt = null;
	public CallableStatement call_stmt = null;
	
	public databaseHandler(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/nadette restaurant",
			"root", "");
}
		
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		}catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
	    }
			}
			
			
}

