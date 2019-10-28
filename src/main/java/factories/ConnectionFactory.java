package factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private String url = "jdbc:mysql://localhost:3306/pedidos";
	private String username = "root";
	private String password = "root";
	
	private static ConnectionFactory instance = null;
	
	private ConnectionFactory() {
	}
	
	public static ConnectionFactory getInstance() {
		if (instance == null) {
			instance = new ConnectionFactory();
		}
		
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn;
		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
}
