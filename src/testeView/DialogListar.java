package testeView;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import br.com.cgpp.vendas.view.JD_Listagem;

public abstract class DialogListar extends JDialog {

	private static JPopupMenu jPopupMenu_table;
	private static JMenuItem jMenuItem_novo;
	private static JMenuItem jMenuItem_editar;
	private static JMenuItem jMenuItem_excluir;
	private static JMenuItem jMenuItem_procurar;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public DialogListar() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblTelaDeListagem = new JLabel("TELA DE LISTAGEM DE CATEGORIAS");
			lblTelaDeListagem.setComponentPopupMenu(getJPopupMenu_table());
			contentPanel.add(lblTelaDeListagem, BorderLayout.NORTH);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ok");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private static JPopupMenu getJPopupMenu_table() {
		if (jPopupMenu_table == null) {
			jPopupMenu_table = new JPopupMenu();
			jPopupMenu_table.add(getJMenuItem_novo());
			jPopupMenu_table.add(getJMenuItem_editar());
			jPopupMenu_table.add(getJMenuItem_excluir());
			jPopupMenu_table.add(getJMenuItem_procurar());
		}
		return jPopupMenu_table;
	}

	/**
	 * This method initializes jMenuItem_novo	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public static JMenuItem getJMenuItem_novo() {
		if (jMenuItem_novo == null) {
			jMenuItem_novo = new JMenuItem();
			jMenuItem_novo.setText("Adicionar");
			jMenuItem_novo.setToolTipText("Adicionar um novo registro");
			jMenuItem_novo.setIcon(new ImageIcon(JD_Listagem.class.getResource("/br/com/cgpp/vendas/img/nav-adiciona.png")));
		}
		return jMenuItem_novo;
	}

	/**
	 * This method initializes jMenuItem_editar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	public static JMenuItem getJMenuItem_editar() {
		if (jMenuItem_editar == null) {
			jMenuItem_editar = new JMenuItem();
			jMenuItem_editar.setText("Editar");
			jMenuItem_editar.setToolTipText("Editar informa\u00E7\u00F5es do registro selecionado");
			jMenuItem_editar.setIcon(new ImageIcon(JD_Listagem.class.getResource("/br/com/cgpp/vendas/img/editar 16x16 (2).png")));
		}
		return jMenuItem_editar;
	}

	public static JMenuItem getJMenuItem_excluir() {
		if (jMenuItem_excluir == null) {
			jMenuItem_excluir = new JMenuItem();
			jMenuItem_excluir.setText("Excluir");
			jMenuItem_excluir.setToolTipText("Excluir um registro selecionado");
			jMenuItem_excluir.setIcon(new ImageIcon(JD_Listagem.class.getResource("/br/com/cgpp/vendas/img/nav-remove.png")));
		}
		return jMenuItem_excluir;
	}
	
	public static JMenuItem getJMenuItem_procurar() {
		if (jMenuItem_procurar == null) {
			jMenuItem_procurar = new JMenuItem();
			jMenuItem_procurar.setText("Procurar");
			jMenuItem_procurar.setToolTipText("Procurar registros");
			jMenuItem_procurar.setIcon(new ImageIcon(JD_Listagem.class.getResource("/br/com/cgpp/vendas/img/lente_aumento.png")));
		}
		return jMenuItem_procurar;
	}

}
