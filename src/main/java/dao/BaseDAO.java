package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDAO {
	
	protected Connection conn;
	protected PreparedStatement pst;
	protected ResultSet rs;

	protected void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch(Exception ignored) {}
		}
	}

	protected void close(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch(Exception ignored) {}
		}
	}
	
	protected void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch(Exception ignored) {}
		}
	}
}
