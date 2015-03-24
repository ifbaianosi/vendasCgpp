package br.com.cgpp.vendas.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import br.com.cgpp.vendas.controller.ListarCategoria;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JF_principal extends JFrame {

	private JPanel contentPane;
	private static JF_principal frame;
	

	/**
	 * Launch the application.
	 */
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		//aparencia do sistema: Look and Feel
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
		
		JMenuItem mntmCategoria = new JMenuItem("Categoria");
		mntmCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListarCategoria(frame, "Lista de categorias", "Listagem de todos os itens de categoria.");
			}
		});
		mnCadastros.add(mntmCategoria);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mnCadastros.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public static JF_principal getFrame() {
		return frame;
	}

}
