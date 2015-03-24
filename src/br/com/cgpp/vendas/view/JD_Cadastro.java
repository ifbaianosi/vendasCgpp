package br.com.cgpp.vendas.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import br.com.cgpp.vendas.utils.PanelFormUICinza;

public class JD_Cadastro extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JButton jButton_fechar = null;
	private JPanel jPanel_left = null;
	private JLabel jLabel3 = null;
	private JPanel jPanel_right = null;
	private JLabel jLabel31 = null;
	private JButton jButton_salvar = null;
	private JLayeredPane jLayeredPane = null;  //  @jve:decl-index=0:visual-constraint="754,169"
	protected JLabel jLabel_iconeTitulo = null;
	private JLabel icone;
	protected JLabel jLabel_titulo2 = null;
	private JLabel titulo;
	private JLabel jLabel_imgDisignRight = null;
	protected JLabel subtitulo = null;
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
			jPanel.add(getJButton_salvar(), null);
			jPanel.add(getJButton_fechar(), null);
		}
		return jPanel;
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
	 * This method initializes jButton_salvar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButton_salvar() {
		if (jButton_salvar == null) {
			jButton_salvar = new JButton();
			jButton_salvar.setToolTipText("Salvar as informa\u00E7\u00F5es");
			jButton_salvar.setText("Salvar");
			jButton_salvar.setIcon(new ImageIcon(JD_Cadastro.class.getResource("/br/com/cgpp/vendas/img/ok 16x16.png")));
		}
		return jButton_salvar;
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
			jButton_fechar.setIcon(new ImageIcon(JD_Cadastro.class.getResource("/br/com/cgpp/vendas/img/Close.png")));
		}
		return jButton_fechar;
	}

	/**
	 * This method initializes jLayeredPane	
	 * 	
	 * @return javax.swing.JLayeredPane	
	 */
	private JLayeredPane getJLayeredPane2() {
		if (jLayeredPane == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints3.gridwidth = 2;
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.anchor = GridBagConstraints.EAST;
			gridBagConstraints3.fill = GridBagConstraints.NONE;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.gridheight = 2;
			GridBagConstraints gbc_titulo = new GridBagConstraints();
			gbc_titulo.insets = new Insets(10, 8, 0, 2);
			gbc_titulo.gridy = 0;
			gbc_titulo.ipadx = 0;
			gbc_titulo.anchor = GridBagConstraints.NORTHWEST;
			gbc_titulo.fill = GridBagConstraints.HORIZONTAL;
			gbc_titulo.gridwidth = 1;
			gbc_titulo.weightx = 1.0;
			gbc_titulo.weighty = 0.0;
			gbc_titulo.gridx = 0;
			GridBagConstraints gbc_subtitulo = new GridBagConstraints();
			gbc_subtitulo.insets = new Insets(0, 45, 4, 25);
			gbc_subtitulo.gridx = 0;
			gbc_subtitulo.gridy = 1;
			gbc_subtitulo.ipadx = 0;
			gbc_subtitulo.anchor = GridBagConstraints.NORTHWEST;
			gbc_subtitulo.weightx = 0.0;
			gbc_subtitulo.fill = GridBagConstraints.HORIZONTAL;
			gbc_subtitulo.weighty = 1.0;
			gbc_subtitulo.gridheight = 1;
			gbc_subtitulo.gridwidth = 3;
			GridBagConstraints gbc_icone = new GridBagConstraints();
			gbc_icone.insets = new Insets(6, 33, 0, 10);
			gbc_icone.gridy = 0;
			gbc_icone.anchor = GridBagConstraints.EAST;
			gbc_icone.gridx = 2;
			jLabel_imgDisignRight = new JLabel();
			jLabel_imgDisignRight.setIcon(new ImageIcon(JD_Cadastro.class.getResource("/br/com/cgpp/vendas/img/head_right 258x54.png")));
			jLabel_imgDisignRight.setText("");
			setTitulo(new JLabel());
			getTitulo().setFont(new Font("Dialog", Font.BOLD, 14));
			getTitulo().setText("Cadastrar");
			getTitulo().setForeground(new Color(102, 102, 102));
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			gridBagConstraints61.anchor = GridBagConstraints.WEST;
			gridBagConstraints61.gridx = 0;
			gridBagConstraints61.gridy = 0;
			gridBagConstraints61.ipadx = 0;
			gridBagConstraints61.ipady = 0;
			gridBagConstraints61.insets = new Insets(10, 6, 10, 0);
			setIcone(new JLabel());
			getIcone().setIcon(new ImageIcon(JD_Cadastro.class.getResource("/br/com/cgpp/vendas/img/1427153490_678092-sign-add-32.png")));
			getIcone().setText(" ");
			jLayeredPane = new JLayeredPane();
			jLayeredPane.setLayout(new GridBagLayout());
			jLayeredPane.setBackground(new Color(255, 255, 255));
			jLayeredPane.setOpaque(true);
			jLayeredPane.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
			jLayeredPane.add(getIcone(), gbc_icone);
			jLayeredPane.add(getSubtitulo(), gbc_subtitulo);
			jLayeredPane.add(getTitulo(), gbc_titulo);
			jLayeredPane.add(jLabel_imgDisignRight, gridBagConstraints3);
		}
		return jLayeredPane;
	}

	/**
	 * This method initializes jLabel2	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	public JLabel getSubtitulo() {
		if (subtitulo == null) {
			subtitulo = new JLabel();
			subtitulo.setText("Titulo auxiliar");
			subtitulo.setForeground(new Color(102, 102, 102));
		}
		return subtitulo;
	}

	/**
	 * @param owner
	 * @wbp.parser.constructor
	 */
	public JD_Cadastro(Frame owner) {
		super(owner);
		initialize();
	}
	
	/**
	 * @param owner
	 */
	public JD_Cadastro(Dialog owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(450, 300);
		this.setMinimumSize(new Dimension(450, 300));
		
		/**
		 *  botao padrao da tela de cadastro  
		 */
		this.getRootPane().setDefaultButton(getJButton_salvar());
		UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
		
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
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	protected JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJLayeredPane2(), BorderLayout.NORTH);
			jContentPane.add(getJPanel(), BorderLayout.SOUTH);
			jContentPane.add(getJPanel_left(), BorderLayout.WEST);
			jContentPane.add(getJPanel_right(), BorderLayout.EAST);
		}
		return jContentPane;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JLabel getIcone() {
		return icone;
	}

	public void setIcone(JLabel icone) {
		this.icone = icone;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
