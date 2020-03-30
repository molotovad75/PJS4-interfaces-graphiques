package application.SGBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD_utilisation {
	
	public Connection get_connection() throws SQLException {
		Connection conn =null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			
//			
//			 String url ="jdbc:mysql://localhost:3306/pjs4?serverTimezone=UTC";
//		     String user ="root";
//		     String passwd ="";
//		         
//		     conn = DriverManager.getConnection(url, user, passwd);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
		
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    try {
	        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/pjs4?serverTimezone=UTC", "root", "");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	

}
