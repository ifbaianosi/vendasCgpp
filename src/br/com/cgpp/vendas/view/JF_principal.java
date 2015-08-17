package br.com.cgpp.vendas.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.cgpp.vendas.controller.ListarCategoria;

public class JF_principal extends JFrame {

	private JPanel contentPane;
	protected JMenuItem mntmCategoria;
	protected JMenuItem mntmSair;
	

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JF_principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JF_principal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		//aparência do sistema: Look and Feel
		try {			
            // select the Look and Feel
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		      SwingUtilities.updateComponentTreeUI(this);
		      
	    } catch (Exception ex) {
	      JOptionPane.showMessageDialog(this, "Não foi possível alterar a Look And Feel do sistema.", "warning", JOptionPane.WARNING_MESSAGE);
	    }
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		mntmCategoria = new JMenuItem("Categoria");
		mnCadastros.add(mntmCategoria);
		
		mntmSair = new JMenuItem("Sair");
		mnCadastros.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		setVisible(true);
	}


	private void listar() {
		new ListarCategoria(this, "Lista de categorias", "Listagem de todos os itens de categoria.");
		
	}

}
