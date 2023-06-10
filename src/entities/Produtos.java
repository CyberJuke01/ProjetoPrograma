package entities;

public class Produtos {
	private Integer id;
	private String nome;
	private Integer quantidade;
	private Double preco;

	public String toString() {
		return "Id: " + id + "\nNome: " + nome + "\nQuantidade: " + quantidade + "\nPreco: R$"
				+ String.format("%.2f", preco) + "\n";
	}

	public Produtos() {

	}

	public Produtos(Integer id, String nome, Integer quantidade, Double preco) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public void addQuantity(Integer quantity) {
		this.quantidade += quantity;
	}
	
	public void removeQuantity(Integer quantity) {
		this.quantidade -= quantity;
	}

}
