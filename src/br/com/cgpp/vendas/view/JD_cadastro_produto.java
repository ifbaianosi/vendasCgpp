package br.com.cgpp.vendas.view;

import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class JD_cadastro_produto extends JD_Cadastro {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JD_cadastro_produto dialog = new JD_cadastro_produto(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JD_cadastro_produto(Dialog owner) {
		super(owner);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		setVisible(true);
	}
}
