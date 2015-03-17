package br.com.cgpp.vendas.model.bean;

import br.com.cgpp.vendas.model.dao.HibernateDAO;


public class Produto {

	private int idproduto;
	private String nome;
	private String descricao;
	private String unidade;
	private double preco;
	private int estoque;
	private int estoqueMinimo;
	private Categoria categoria;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public static void main(String[] args) {
	/*Produto p = new Produto();
	p.setUnidade("unidade");
	p.setPreco(20.5);
	p.setNome("nome");
	p.setEstoqueMinimo(50);
	p.setEstoque(60);
	p.setDescricao("descricao");
	HibernateDAO<Categoria> teste = new HibernateDAO<>(Categoria.class);
	p.setCategoria(teste.getBean(1));
	
	HibernateDAO<Produto> pDAO = new HibernateDAO<>(Produto.class);
	pDAO.salvar(p);*/
		
	HibernateDAO<Produto> pDAO = new HibernateDAO<>(Produto.class);
	
	Produto p = pDAO.getBean(1);
	System.out.println("nome.: "+p.getNome()+"\nestoque.: "+p.getEstoque()+"\npreco.: "+p.getPreco()+"\ncategoria.: "+p.getCategoria().getNome());
		
	}

}