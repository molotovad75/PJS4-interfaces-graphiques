package application.SGBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDD_connexion {
	private static final String username="root";
	private static final String password="";
	
	public static Connection connect() {
		try {
			String URL="jdbc:mysql://localhost:3306/pjs4";

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(URL,username,password);
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			Logger.getLogger(BDD_connexion.class.getName()).log(Level.SEVERE, null,e);
		}
		return null;
		
	}
	
}
