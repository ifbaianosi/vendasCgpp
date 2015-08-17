package br.com.cgpp.vendas.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.cgpp.vendas.view.JF_principal;

public final class Teste extends JF_principal implements ActionListener {

	public Teste(){
		mntmCategoria.addActionListener(this);
		mntmSair.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== mntmCategoria){
	  new ListarCategoria(this, "Lista de categorias", "Listagem de todos os itens de categoria.");

		}else
		if(e.getSource()==mntmSair){
			dispose();
		}
		
	}
	
}
