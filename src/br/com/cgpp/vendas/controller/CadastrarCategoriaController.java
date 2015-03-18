package br.com.cgpp.vendas.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.cgpp.vendas.model.bean.Categoria;
import br.com.cgpp.vendas.model.dao.HibernateDAO;
import br.com.cgpp.vendas.view.CadastrarCategoria;


public class CadastrarCategoriaController extends CadastrarCategoria implements ActionListener{

	public CadastrarCategoriaController(){
	salvar.addActionListener(this);
	cancelar.addActionListener(this);
	setVisible(true);	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		Object source = event.getSource();
		
		if(source==salvar){
			Categoria categoria = new Categoria();
			categoria.setNome(nome.getText());
			categoria.setDescricao(descricao.getText());
			
			try {
				HibernateDAO<Categoria> dao = new HibernateDAO<Categoria>(Categoria.class);
				dao.salvar(categoria);
				JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!"); 
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Erro ao cadastrar");
			}
			
			
		}else if(source==cancelar){
			System.exit(0);
		}
	
	}
}
