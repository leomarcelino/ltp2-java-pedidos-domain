package dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import factories.ConnectionFactory;
import models.Produto;

public class ProdutoDAO extends BaseDAO {
	
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
				produto = readFieldValues();
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

	private Produto readFieldValues() throws SQLException {
		Produto produto;
		produto = new Produto();
		produto.setId(rs.getLong("id"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setPreco(rs.getDouble("preco"));
		produto.setEstoque(rs.getDouble("estoque"));
		
		return produto;
	}

	
	public List<Produto> list(String termo) {
		String sql = "SELECT id, descricao, preco, estoque"
				+ " FROM produtos";
		
		if (termo != null && !termo.isEmpty()) {
			sql += " WHERE descricao like ?";
		}
		
		List<Produto> lista = new ArrayList<>();
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			pst = conn.prepareStatement(sql);
			
			if (termo != null && !termo.isEmpty()) {
				pst.setString(1, '%' + termo + '%');
			}
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Produto produto = readFieldValues();
				
				lista.add(produto);
			}
		} catch(SQLException e) {
			throw new RuntimeException("Erro ao ler registros");
		}
		
		close(rs);
		close(pst);
		close(conn);
				
		return lista;
	}
	
	public Produto update(Produto produto) {
		String sql = "UPDATE produtos SET "
				+ " descricao = ?,"
				+ " preco = ?,"
				+ " estoque = ?"
				+ " WHERE id = ?";
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, produto.getDescricao());
			pst.setDouble(2, produto.getPreco());
			pst.setDouble(3, produto.getEstoque());
			pst.setLong(4, produto.getId());
			pst.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException("Erro ao atualizar registro");
		}
		
		close(pst);
		close(conn);
		
		return produto;
	}
	
	public void delete(Produto produto) {
		String sql = "DELETE FROM produtos "
				+ " WHERE id = ?";
		
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			pst = conn.prepareStatement(sql);
			pst.setLong(1, produto.getId());
			pst.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException("Erro ao excluir registro");
		}
		
		close(pst);
		close(conn);
	}
}