package br.com.cgpp.vendas.model.bean;

import br.com.cgpp.vendas.model.dao.HibernateDAO;


public class Categoria {

	private int idcategoria;
	private String nome;
	private String descricao;

	public int getIdcategoria() {
		return idcategoria;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}


	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static void main(String[] args) {
		
		Categoria categoria = new Categoria();
		categoria.setNome("agora vai baitolinha");
		categoria.setDescricao("teste teste");
		
		HibernateDAO<Categoria> dao = new HibernateDAO<Categoria>(Categoria.class);
		dao.salvar(categoria);
	}


}