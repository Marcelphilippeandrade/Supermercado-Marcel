package br.com.supermercado.marcel.constantes;

public enum Tipo {

	BEBIDA("benida"), 
	LATICINIO("Laticínio"),
	BISCOITO("biscoito"),
	ENLATADO("Enlatado"),
	BELEZA("beleza"),
	HIGIENE_E_LIMPEZA("higiene e limpeza");

	private String descricao;

	private Tipo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
