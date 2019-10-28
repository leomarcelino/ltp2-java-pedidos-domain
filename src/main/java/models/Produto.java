package models;

public class Produto {

	private long id;
	
	private String descricao;
	
	private double preco;
	
	private double estoque;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if (id < 0) throw new IllegalArgumentException("Id não pode ser negativo");
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco < 0) throw new IllegalArgumentException("Preço não pode ser negativo");
		this.preco = preco;
	}

	public double getEstoque() {
		return estoque;
	}

	public void setEstoque(double estoque) {
		this.estoque = estoque;
	}

	public void creditarEstoque(double quantidade) {
		this.estoque += quantidade;
	}
	
	public void debitarEstoque(double quantidade) {
		this.estoque -= quantidade;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", preco=" + preco + ", estoque=" + estoque + "]";
	}

}