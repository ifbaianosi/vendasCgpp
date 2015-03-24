package br.com.cgpp.vendas.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ListarCategoria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField pesquisa;
	public JButton cancelar;
	public JButton deletar;
	

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
				deletar = new JButton("Deletar");
				deletar.setActionCommand("OK");
				buttonPane.add(deletar);
				getRootPane().setDefaultButton(deletar);
			}
			{
				cancelar = new JButton("Cancelar");
				cancelar.setActionCommand("Cancel");
				buttonPane.add(cancelar);
			}
		}
		
		pesquisa = new JTextField();
		pesquisa.setBounds(98, 34, 265, 20);
		getContentPane().add(pesquisa);
		pesquisa.setColumns(10);
		
		JLabel lblNome = new JLabel("Pesquisar:");
		lblNome.setBounds(26, 37, 62, 14);
		getContentPane().add(lblNome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 72, 337, 103);
		getContentPane().add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(tabbedPane);
	}
}
