package br.com.supermercado.marcel.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lote")
public class Lote {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "data_fabricacao")
	private LocalDate dataFabricacao;

	@OneToMany(mappedBy = "lote", cascade = CascadeType.ALL)
	private List<Item> itens;

	public Lote() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	@Override
	public String toString() {
		return "Lote [id=" + id + ", codigo=" + codigo + ", Data Fabricação=" + dataFabricacao + "]";
	}
}
