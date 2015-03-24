package br.com.cgpp.vendas.view;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.cgpp.vendas.utils.BackgroundFocusField;
import br.com.cgpp.vendas.utils.FixedLengthDocument;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.UIManager;

public class JD_cadastro_categoria extends JD_Cadastro {

	protected JPanel form_categoria;
	protected JTextField nomeJTextField;
	protected JTextArea descricaoJTextArea;
	protected JLabel alerta;
	
	/**
	 * Create the dialog.
	 */
	public JD_cadastro_categoria(Frame owner) {
		super(owner);
		inicializeForm();
	}
	
	/**
	 * Create the dialog.
	 */
	public JD_cadastro_categoria(Dialog owner) {
		super(owner);
		inicializeForm();
	}

	private void inicializeForm() {
		titulo.setText("Cadastrar Categoria");
		form_categoria = new JPanel();
		getJContentPane().add(form_categoria, BorderLayout.CENTER);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0E-4 };
		form_categoria.setLayout(gridBagLayout);

		JLabel nomeLabel = new JLabel("Nome*"); 
		GridBagConstraints labelGbc_0 = new GridBagConstraints(); 
		labelGbc_0.anchor = GridBagConstraints.WEST;
		labelGbc_0.insets = new Insets(10, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		form_categoria.add(nomeLabel, labelGbc_0);

		nomeJTextField = new JTextField();		
		nomeJTextField.setDocument(new FixedLengthDocument(50));
		BackgroundFocusField.requestFocus(nomeJTextField);
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(10, 0, 5, 0);
		componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		form_categoria.add(nomeJTextField, componentGbc_0);

		JLabel descricaoLabel = new JLabel("Descricao");
		GridBagConstraints labelGbc_1 = new GridBagConstraints();
		labelGbc_1.ipadx = 30;
		labelGbc_1.anchor = GridBagConstraints.NORTHWEST;
		labelGbc_1.insets = new Insets(5, 5, 5, 5);
		labelGbc_1.gridx = 0;
		labelGbc_1.gridy = 1;
		form_categoria.add(descricaoLabel, labelGbc_1);
		
		descricaoJTextArea = new JTextArea();
		descricaoJTextArea.setLineWrap(true);
		descricaoJTextArea.setDocument(new FixedLengthDocument(250));
		BackgroundFocusField.requestFocus(descricaoJTextArea);
		GridBagConstraints gbc_txtrTeste = new GridBagConstraints();
		gbc_txtrTeste.fill = GridBagConstraints.BOTH;
		gbc_txtrTeste.insets = new Insets(0, 0, 5, 0);
		gbc_txtrTeste.gridx = 1;
		gbc_txtrTeste.gridy = 1;
		//add(txtrTeste, gbc_txtrTeste);
		JScrollPane sp = new JScrollPane(descricaoJTextArea);
		form_categoria.add(sp, gbc_txtrTeste);
		
		alerta = new JLabel("Campos com asterisco (*) requer preenchimento obrigat\u00F3rio.");
		GridBagConstraints gbc_alerta = new GridBagConstraints();
		gbc_alerta.anchor = GridBagConstraints.NORTHWEST;
		gbc_alerta.insets = new Insets(0, 0, 0, 5);
		gbc_alerta.gridx = 1;
		gbc_alerta.gridy = 2;
		form_categoria.add(alerta, gbc_alerta);
	}

}
