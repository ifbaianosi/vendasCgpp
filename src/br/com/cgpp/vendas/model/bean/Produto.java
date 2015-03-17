package br.com.cgpp.vendas.model.bean;


public class Produto {

	private int idproduto;
	private String nome;
	private String descricao;
	private String unidade;
	private double preco;
	private int estoque;
	private int estoqueMinimo;
	private int categoria_idcategoria;

	public int getIdproduto() {
		return idproduto;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public double getPreco() {
		return preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public int getCategoria_idcategoria() {
		return categoria_idcategoria;
	}


	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public void setCategoria_idcategoria(int categoria_idcategoria) {
		this.categoria_idcategoria = categoria_idcategoria;
	}


}