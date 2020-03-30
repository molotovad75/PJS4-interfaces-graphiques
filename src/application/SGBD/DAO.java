package application.SGBD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAO {
	public static void insérer_data(String req) {
		BDD_utilisation bd_co=new BDD_utilisation();
		
		PreparedStatement ps=null;
		try {
			Connection connection=bd_co.get_connection();
			ps=connection.prepareStatement(req);
			ps.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
