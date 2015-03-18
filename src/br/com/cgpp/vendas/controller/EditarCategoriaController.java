package br.com.cgpp.vendas.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.cgpp.vendas.model.bean.Categoria;
import br.com.cgpp.vendas.model.dao.HibernateDAO;
import br.com.cgpp.vendas.view.CadastrarCategoria;
import br.com.cgpp.vendas.view.EditarCategoria;


@SuppressWarnings("serial")
public class EditarCategoriaController extends EditarCategoria implements ActionListener{
	private Categoria cat;
	private HibernateDAO<Categoria> dao;
	
	public EditarCategoriaController(){
	atualizar.addActionListener(this);
	cancelar.addActionListener(this);
	dao = new HibernateDAO<Categoria>(Categoria.class);
	cat = dao.getBean(5);
	nome.setText(cat.getNome());
	descricao.setText(cat.getDescricao());
	setVisible(true);	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event){
		Object source = event.getSource();
		
		if(source==atualizar){
			cat.setNome(nome.getText());
			cat.setDescricao(descricao.getText());
			
			try {
				dao.atualizar(cat);
				JOptionPane.showMessageDialog(this, "Atualizado com sucesso!"); 
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Erro ao atualizar");
			}
			
			
		}else if(source==cancelar){
			System.exit(0);
		}
	
	}
}
