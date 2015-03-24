package br.com.cgpp.vendas.model.bean;

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

	public boolean isValid() {
		if (nome != null){
			return true;			
		}else{
			return false;
		}
	}


}