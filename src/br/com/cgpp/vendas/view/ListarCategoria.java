package br.com.cgpp.vendas.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ListarCategoria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField nome;
	public JTextField descricao;
	public JButton cancelar;
	public JButton salvar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarCategoria dialog = new ListarCategoria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarCategoria() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1, 229);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				salvar = new JButton("Salvar");
				salvar.setActionCommand("OK");
				buttonPane.add(salvar);
				getRootPane().setDefaultButton(salvar);
			}
			{
				cancelar = new JButton("Cancelar");
				cancelar.setActionCommand("Cancel");
				buttonPane.add(cancelar);
			}
		}
		
		nome = new JTextField();
		nome.setBounds(98, 78, 265, 20);
		getContentPane().add(nome);
		nome.setColumns(10);
		
		descricao = new JTextField();
		descricao.setBounds(98, 122, 265, 20);
		getContentPane().add(descricao);
		descricao.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(26, 81, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(26, 125, 62, 14);
		getContentPane().add(lblDescrio);
	}
}
