package models;

public enum TipoPessoa {
	FISICA,
	JURIDICA;
	
	public static TipoPessoa parse(int value) {
		return values()[value];
	}
}
