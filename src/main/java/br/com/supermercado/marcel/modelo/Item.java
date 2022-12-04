package br.com.supermercado.marcel.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.supermercado.marcel.constantes.Tipo;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "preco")
	private Double preco;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "codigo_barras")
	private String codigoBarras;

	@Column (name = "tipo")
	@Enumerated(EnumType.STRING)
	private Tipo tipoEnum;
	
	@Column(name = "data_validade")
	private Date dataValidade;
	
	@Column(name = "data_fabricacao")
	private Date dataFabricacao;
	
	@ManyToOne
	private Lote lote;

	public Item() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Tipo getTipoEnum() {
		return tipoEnum;
	}

	public void setTipoEnum(Tipo tipoEnum) {
		this.tipoEnum = tipoEnum;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	@Override
	public String toString() {
		return "item{" + "id = " + id + ", nome = " + nome + ", preco = " + preco + ", descrição = " + descricao + "}";
	}

}
