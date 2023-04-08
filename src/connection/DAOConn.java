package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DAOConn {
	
	public Connection conectBD() {
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/pi6bd?user=root&password=";
			conn = DriverManager.getConnection(url);
			
		} catch (SQLException e) {
			System.out.println("DAOConn: " + e.getMessage());
		}
		return conn;
	}

}
