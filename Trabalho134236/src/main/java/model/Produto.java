package model;
import java.io.Serializable;
import java.math.BigDecimal;

//int id, String descrição, BigDecimal preço
public class Produto implements Serializable{

	private int id;
	private String descricao;
	private BigDecimal preco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
}
