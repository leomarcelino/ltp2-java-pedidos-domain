package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private long id;
	
	private LocalDate data;
	
	private Cliente cliente;
	
	private List<Produto> itens;
	
	public Pedido() {
		itens = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if (id < 0) throw new IllegalArgumentException("Id não pode ser negativo");
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getItens() {
		return itens;
	}

	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}
}