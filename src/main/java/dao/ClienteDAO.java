package dao;

import java.sql.SQLException;
import java.util.List;

import models.Cliente;
import models.TipoPessoa;

public class ClienteDAO extends BaseDAO {
	
	public Cliente create(Cliente cliente) {
		/*
		 * TODO: Implementar logica
		 */
		
		try {
			
			pst.setInt(3, cliente.getTipoPessoa().ordinal());
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao salvar registro");
		}
		
		return cliente;
	}
	
	public Cliente find(long id) {
		/*
		 * TODO: Implementar logica
		 */
		
		Cliente cliente = new Cliente();
		
		try {
			cliente.setTipoPessoa(TipoPessoa.parse(rs.getInt("tipo_pessoa")));
		} catch(SQLException e) {
			throw new RuntimeException("Erro ao ler registro");
		}
		
		return null;
	}
	
	public List<Cliente> list(String termo) {
		/*
		 * TODO: Implementar logica
		 */
		
		return null;
	}
	
	public Cliente update(Cliente cliente) {
		/*
		 * TODO: Implementar logica
		 */
		
		return cliente;
	}
	
	
	public void delete(Cliente cliente) {
		/*
		 * TODO: Implementar logica
		 */
		
	}
	
}
