package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import factories.ConnectionFactory;
import models.Produto;

public class ProdutoDAO {

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public Produto create(Produto produto) {
		String sql = "INSERT INTO produtos(descricao, preco, estoque)"
				+ " VALUES(?, ?, ?)";
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, produto.getDescricao());
			pst.setDouble(2, produto.getPreco());
			pst.setDouble(3, produto.getEstoque());
			pst.executeUpdate();
			
			rs = pst.getGeneratedKeys();
			if (rs.next()) {
				produto.setId(rs.getLong(1));
			}
		} catch(SQLException e) {
			throw new RuntimeException("Error in creating record", e);
		} finally {
			close(conn);
			close(pst);
			close(rs);
		}
		
		return produto;
	}

	public Produto find(long id) {
		String sql = "SELECT id, descricao, preco, estoque"
				+ " FROM produtos WHERE id = ?";
		
		Produto produto = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			pst = conn.prepareStatement(sql);
			
			pst.setLong(1, id);
			
			rs = pst.executeQuery();
			
			if (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setEstoque(rs.getDouble("estoque"));
			}
		} catch(SQLException e) {
			throw new RuntimeException("Error in finding record", e);
		} finally {
			close(conn);
			close(pst);
			close(rs);
		}
		
		return produto;
	}

	
	public List<Produto> list() {
		return new ArrayList<Produto>();
	}
	
	public Produto update(Produto produto) {
		return produto;
	}
	
	public void delete(Produto produto) {
		
	}
	
	private void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch(Exception ignored) {}
		}
	}

	private void close(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch(Exception ignored) {}
		}
	}
	
	private void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch(Exception ignored) {}
		}
	}
}