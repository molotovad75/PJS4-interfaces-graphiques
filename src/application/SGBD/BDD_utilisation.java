package application.SGBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BDD_utilisation {
//	private static final String username="root";
//	private static final String password="";
	
	public static Connection connect_select(String reqSQL) throws SQLException {
//		try {
//			String URL="jdbc:mysql://localhost:3306/pjs4";
//
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn=DriverManager.getConnection(URL,username,password);
//			return conn;
//		} catch (ClassNotFoundException | SQLException e) {
//			Logger.getLogger(BDD_connexion.class.getName()).log(Level.SEVERE, null,e);
//		}
//		return null;
		Connection conn =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 String url ="jdbc:mysql://localhost:3306/pjs4?useSSL=false&serverTimezone=UTC";
		     String user ="root";
		     String passwd ="";
		         
		     conn = DriverManager.getConnection(url, user, passwd);
		         
		     //Création d'un objet Statement
		     Statement state = conn.createStatement();
		     //L'objet ResultSet contient le résultat de la requête SQL
		     ResultSet result = state.executeQuery(reqSQL);
		     //On récupère les MetaData
		     ResultSetMetaData resultMeta = result.getMetaData();
		         
		     System.out.println("\n**********************************");
		     //On affiche le nom des colonnes
		     for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		       System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
		        
		     System.out.println("\n**********************************");
		         
		     while(result.next()){         
		       for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		         System.out.print("\t" + result.getObject(i).toString() + "\t |");
		            
		       System.out.println("\n---------------------------------");

		     }

		     result.close();
		     state.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection connect_other_query(String reqSQL) throws SQLException {
		Connection conn =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 String url ="jdbc:mysql://localhost:3306/pjs4";
		     String user ="root";
		     String passwd ="";
		         
		     conn = DriverManager.getConnection(url, user, passwd);
		         
		     //Création d'un objet Statement
		     Statement state = conn.createStatement();
		     //L'objet ResultSet contient le résultat de la requête SQL
		     state.executeUpdate(reqSQL);
		     state.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
		
	}
	
}
