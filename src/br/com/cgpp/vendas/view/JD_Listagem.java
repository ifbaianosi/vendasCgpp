package br.com.cgpp.vendas.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import br.com.cgpp.vendas.utils.PanelFormUICinza;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import java.awt.Window.Type;

public class JD_Listagem extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JButton jButton_fechar = null;
	private JPanel jPanel_conteudo = null;
	private JToolBar jJToolBarBar = null;
	private JButton jButton_novo = null;
	private JButton jButton_editar = null;
	private JButton jButton_procurar = null;
	private JScrollPane jScrollPane = null;
	private static JTable jTable = null;
	public static JLabel jLabel2 = null;
	private JPanel jPanel_left = null;
	private JPanel jPanel_detalhes_right_jtable = null;
	private JLabel jLabel3 = null;
	private JPanel jPanel_right = null;
	private JLabel jLabel31 = null;
	private JLayeredPane jLayeredPane = null;  //  @jve:decl-index=0:visual-constraint="754,64"
	protected JLabel icone;
	protected JLabel subtitulo;
	protected JLabel titulo;
	private JLabel jLabel_imgDisignRight = null;
	private JPanel jPanel1 = null;  //  @jve:decl-index=0:visual-constraint="724,78"
	private JButton btnExcluir;
	private static JPopupMenu jPopupMenu_table;
	private static JMenuItem jMenuItem_novo;
	private static JMenuItem jMenuItem_editar;
	private static JMenuItem jMenuItem_excluir;
	private static JMenuItem jMenuItem_procurar;
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setUI(new PanelFormUICinza());
			jPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
			jPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			jPanel.add(getJButton_fechar(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton_fechar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButton_fechar() {
		if (jButton_fechar == null) {
			jButton_fechar = new JButton();
			jButton_fechar.setToolTipText("Fechar esta janela");
			jButton_fechar.setText("Fechar");
			jButton_fechar.setIcon(new ImageIcon(JD_Listagem.class.getResource("/br/com/cgpp/vendas/img/Close.png")));
		}
		return jButton_fechar;
	}

	/**
	 * This method initializes jPanel_conteudo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_conteudo() {
		if (jPanel_conteudo == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("carregando dados");
			jPanel_conteudo = new JPanel();
			jPanel_conteudo.setLayout(new BorderLayout());
			jPanel_conteudo.add(getJPanel1(), BorderLayout.NORTH);
			jPanel_conteudo.add(jLabel2, BorderLayout.SOUTH);
			jPanel_conteudo.add(getJPanel_detalhes_right_jtable(), BorderLayout.EAST);
			jPanel_conteudo.add(getJScrollPane(), BorderLayout.CENTER);
		}
		return jPanel_conteudo;
	}

	/**
	 * This method initializes jJToolBarBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJJToolBarBar() {
		if (jJToolBarBar == null) {
			jJToolBarBar = new JToolBar();
			jJToolBarBar.setFloatable(false);
			jJToolBarBar.add(getJButton_novo());
			jJToolBarBar.add(getJButton_editar());
			jJToolBarBar.add(getJButton_procurar());
			jJToolBarBar.add(getBtnExcluir());
		}
		return jJToolBarBar;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
public JButton getJButton_novo() {
		if (jButton_novo == null) {
			jButton_novo = new JButton();
			jButton_novo.setMnemonic('n');
			jButton_novo.setToolTipText("Adicionar um novo registro");
			jButton_novo.setIcon(new ImageIcon(JD_Listagem.class.getResource("/br/com/cgpp/vendas/img/nav-adiciona.png")));
			jButton_novo.setText("Novo");
		}
		return jButton_novo;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButton_editar() {
		if (jButton_editar == null) {
			jButton_editar = new JButton();
			jButton_editar.setMnemonic('e');
			jButton_editar.setToolTipText("Editar informa\u00E7\u00F5es do registro selecionado");
			jButton_editar.setIcon(new ImageIcon(JD_Listagem.class.getResource("/br/com/cgpp/vendas/img/1427155849_edit.png")));
			jButton_editar.setText("Editar");
		}
		return jButton_editar;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButton_procurar() {
		if (jButton_procurar == null) {
			jButton_procurar = new JButton();
			jButton_procurar.setMnemonic('p');
			jButton_procurar.setToolTipText("Procurar registros");
			jButton_procurar.setIcon(new ImageIcon(JD_Listagem.class.getResource("/br/com/cgpp/vendas/img/1427155999_xmag.png")));
			jButton_procurar.setText("Procurar");
		}
		return jButton_procurar;
	}

	public JButton getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new JButton("Excluir");
			btnExcluir.setMnemonic('x');
			btnExcluir.setToolTipText("Excluir um registro selecionado");
			btnExcluir.setIcon(new ImageIcon(JD_Listagem.class.getResource("/br/com/cgpp/vendas/img/nav-remove.png")));
		}
		return btnExcluir;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	public static JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			jTable.setAutoscrolls(true);
			jTable.setComponentPopupMenu(getJPopupMenu_table());
			
			jTable.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_TAB)
					{
							jTable.nextFocus();
					}
				}
			});
			
			Action enterAction = new AbstractAction()  
	        {  
					@Override
					public void actionPerformed(ActionEvent e) {
													
					}  	          
	         };
	         
        InputMap im = null;
     	KeyStroke enter = null;
		
		im = jTable.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);  
        enter = KeyStroke.getKeyStroke("ENTER");  
        im.put(enter, im.get(KeyStroke.getKeyStroke(KeyEvent.VK_GREATER, 0)));  
        jTable.getActionMap().put(im.get(enter), enterAction);
        
		}
		return jTable;
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
	/**
	 * This method initializes jPanel_left	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_left() {
		if (jPanel_left == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("    ");
			jPanel_left = new JPanel();
			jPanel_left.setLayout(new GridBagLayout());
			jPanel_left.add(jLabel3, new GridBagConstraints());
		}
		return jPanel_left;
	}

	/**
	 * This method initializes jPanel_detalhes_right_jtable	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_detalhes_right_jtable() {
		if (jPanel_detalhes_right_jtable == null) {
			jPanel_detalhes_right_jtable = new JPanel();
			jPanel_detalhes_right_jtable.setLayout(new GridBagLayout());
		}
		return jPanel_detalhes_right_jtable;
	}

	/**
	 * This method initializes jPanel_right	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_right() {
		if (jPanel_right == null) {
			jLabel31 = new JLabel();
			jLabel31.setText("    ");
			jPanel_right = new JPanel();
			jPanel_right.setLayout(new GridBagLayout());
			jPanel_right.add(jLabel31, new GridBagConstraints());
		}
		return jPanel_right;
	}

	/**
	 * This method initializes jLayeredPane	
	 * 	
	 * @return javax.swing.JLayeredPane	
	 */
	private JLayeredPane getJLayeredPane() {
		if (jLayeredPane == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.anchor = GridBagConstraints.SOUTHEAST;
			gridBagConstraints3.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints3.gridheight = 2;
			gridBagConstraints3.gridwidth = 2;
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.weightx = 1.0;
			jLabel_imgDisignRight = new JLabel();
			jLabel_imgDisignRight.setIcon(new ImageIcon(JD_Listagem.class.getResource("/br/com/cgpp/vendas/img/head_right 258x54.png")));
			jLabel_imgDisignRight.setText("");
			GridBagConstraints gbc_titulo = new GridBagConstraints();
			gbc_titulo.insets = new Insets(10, 8, 0, 2);
			gbc_titulo.gridwidth = 1;
			gbc_titulo.gridx = 0;
			gbc_titulo.gridy = 0;
			gbc_titulo.ipadx = 0;
			gbc_titulo.weightx = 1.0;
			gbc_titulo.weighty = 0.0;
			gbc_titulo.fill = GridBagConstraints.HORIZONTAL;
			titulo = new JLabel();
			titulo.setFont(new Font("Dialog", Font.BOLD, 18));
			titulo.setText("Listar todos os itens");
			titulo.setForeground(new Color(102, 102, 102));
			GridBagConstraints gbc_subtitle = new GridBagConstraints();
			gbc_subtitle.anchor = GridBagConstraints.NORTHWEST;
			gbc_subtitle.insets = new Insets(0, 45, 5, 25);
			gbc_subtitle.gridheight = 1;
			gbc_subtitle.gridwidth = 2;
			gbc_subtitle.gridx = 0;
			gbc_subtitle.gridy = 1;
			gbc_subtitle.ipadx = 0;
			gbc_subtitle.weightx = 0.0;
			gbc_subtitle.weighty = 1.0;
			gbc_subtitle.fill = GridBagConstraints.HORIZONTAL;
			subtitulo = new JLabel();
			subtitulo.setForeground(new Color(102, 102, 102));
			subtitulo.setText("Titulo auxiliar");
			GridBagConstraints gbc_icone = new GridBagConstraints();
			gbc_icone.ipady = 6;
			gbc_icone.anchor = GridBagConstraints.SOUTHEAST;
			gbc_icone.gridx = 2;
			gbc_icone.gridy = 0;
			gbc_icone.insets = new Insets(0, 28, 0, 6);
			icone = new JLabel();
			icone.setIcon(new ImageIcon(JD_Listagem.class.getResource("/br/com/cgpp/vendas/img/1426894415_699397-icon-40-clipboard-list-48.png")));
			icone.setText(" ");
			jLayeredPane = new JLayeredPane();
			GridBagLayout gbl_jLayeredPane = new GridBagLayout();
			gbl_jLayeredPane.columnWeights = new double[]{0.0, 0.0, 0.0};
			gbl_jLayeredPane.rowWeights = new double[]{0.0, 0.0};
			jLayeredPane.setLayout(gbl_jLayeredPane);
			jLayeredPane.setBackground(new Color(255, 255, 255));
			jLayeredPane.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
			jLayeredPane.setOpaque(true);
			jLayeredPane.add(icone, gbc_icone);
			jLayeredPane.add(subtitulo, gbc_subtitle);
			jLayeredPane.add(titulo, gbc_titulo);
			jLayeredPane.add(jLabel_imgDisignRight, gridBagConstraints3);
		}
		return jLayeredPane;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new Insets(8, 0, 8, 0);
			gridBagConstraints4.gridx = 0;
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.setSize(new Dimension(276, 42));
			jPanel1.add(getJJToolBarBar(), gridBagConstraints4);
		}
		return jPanel1;
	}
	

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), BorderLayout.SOUTH);
			jContentPane.add(getJLayeredPane(), BorderLayout.NORTH);
			jContentPane.add(getJPanel_left(), BorderLayout.WEST);
			jContentPane.add(getJPanel_right(), BorderLayout.EAST);
			jContentPane.add(getJPanel_conteudo(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	
	/**
	 * @param owner
	 */
	public JD_Listagem(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(700, 500);
		this.setContentPane(getJContentPane());
		this.setMinimumSize(new Dimension(300, 150));
		this.setLocationRelativeTo(null);
		this.setModal(true);
		
		/**
		 *  evento da tecla Esc 
		 *  fecha a janela de cadastro  
		 */
		getJButton_fechar().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "actionName");
		getJButton_fechar().getActionMap().put("actionName",new AbstractAction("actionName") 
			{
				public void actionPerformed(ActionEvent evt) {
					dispose();
				}
			}
		);
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
