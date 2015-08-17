package br.com.cgpp.vendas.view;

import java.awt.Dialog;
import java.awt.Frame;

import javax.swing.table.DefaultTableModel;

public class JD_listar_categoria extends JD_Listagem {

	/**
	 * Create the dialog.
	 */
	public JD_listar_categoria(Frame owner) {
		super(owner);
		String cabecalho [] = {"ID", "NOME", "CÓDIGO", "DESCRIÇÃO"};
		
		getJTable().setModel(new DefaultTableModel(
				new Object [0][0],
				cabecalho
		));
		
		getJTable().getColumnModel().getColumn(0).setPreferredWidth(60);
		
		getJTable().getColumnModel().getColumn(1).setPreferredWidth(180);
		
		getJTable().getColumnModel().getColumn(2).setPreferredWidth(60);
		
		getJTable().getColumnModel().getColumn(3).setPreferredWidth(400);		
	}
}
