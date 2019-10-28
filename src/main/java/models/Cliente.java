package models;

import validators.CnpjCpfValidator;

public class Cliente {

	private long id;
	
	private String nome;
	
	private TipoPessoa tipoPessoa;
	
	private String cnpjCpf;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if (id < 0) throw new IllegalArgumentException("Id não pode ser negativo");
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		if (tipoPessoa == null) throw new IllegalArgumentException("Tipo de Pessoa inválido");
		this.tipoPessoa = tipoPessoa;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		if (!CnpjCpfValidator.isValid(cnpjCpf)) throw new IllegalArgumentException("CNPJ/CPF inválido");
		this.cnpjCpf = cnpjCpf;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", tipoPessoa=" + tipoPessoa + ", cnpjCpf=" + cnpjCpf + "]";
	}
	
}