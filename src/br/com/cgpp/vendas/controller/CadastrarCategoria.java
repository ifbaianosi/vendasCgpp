package br.com.cgpp.vendas.controller;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import br.com.cgpp.vendas.model.bean.Categoria;
import br.com.cgpp.vendas.model.dao.HibernateDAO;
import br.com.cgpp.vendas.utils.UIUtils;
import br.com.cgpp.vendas.view.JD_Cadastro;
import br.com.cgpp.vendas.view.JD_Listagem;
import br.com.cgpp.vendas.view.JD_cadastro_categoria;



@SuppressWarnings("serial")
public class CadastrarCategoria extends JD_cadastro_categoria implements ActionListener{

	private HibernateDAO<Categoria> dao;
	private Categoria cat;
	private UIUtils UIUtils;
	private String campoObrigatorio = "";
	private int qtdErroCampoObrt = 0;
	
	/**
	 * construtor responsável por renderizar a tela de cadastro
	 * 
	 * @param owner, janela pai
	 * @param titulo, titulo da janela
	 * @param subtitulo, titulo auxiliar
	 */
	public CadastrarCategoria(Dialog owner, String titulo, String subtitulo) {		
		super(owner);
		UIUtils = new UIUtils();
		getTitulo().setText(titulo);
		getSubtitulo().setText(subtitulo);
		dao = new HibernateDAO<Categoria>(Categoria.class);
		this.cat = new Categoria();
		this.cat.setIdcategoria(0);
		addEventos();
		//setModal(true);		
		//setVisible(true);
	}
	
	/**
	 * ATUALIZAR
	 * construtor responsavel por renderizar a tela de atualização de informações
	 * 
	 * @param owner, janela pai
	 * @param cat, tipo de objeto a ser atualizado na base de dados
	 * @param titulo, titulo da janela
	 * @param subtitulo, titulo auxiliar
	 */
	public CadastrarCategoria(Dialog owner, Categoria cat, String titulo, String subtitulo) {		
		super(owner);
		UIUtils = new UIUtils();
		getTitulo().setText(titulo);
		getSubtitulo().setText(subtitulo);
		getJButton_salvar().setText("Atualizar");
		getJButton_salvar().setToolTipText("Atualizar informações");
		getIcone().setIcon(new ImageIcon(JD_Cadastro.class.getResource("/br/com/cgpp/vendas/img/1427155842_edit.png")));
		this.dao = new HibernateDAO<Categoria>(Categoria.class);
		this.cat = dao.getBean(cat.getIdcategoria());
		
		getNomeJTextField().setText(this.cat.getNome());
		getDescricaoJTextArea().setText(this.cat.getDescricao());
		addEventos();
		//setModal(true);		
		//setVisible(true);
	}
	
	/**
	 * construtor responsavel por renderizar a tela de procura
	 * 
	 * @param owner
	 * @param titulo, titulo da janela
	 * @param subtitulo, titulo auxiliar
	 * @param procurar, parametro do tipo inteiro para informar que a janela será de busca, valor=-1
	 */
	public CadastrarCategoria(Dialog owner, String titulo, String subtitulo, int procurar) {		
		super(owner);
		this.UIUtils = new UIUtils();
		getTitulo().setText(titulo);
		getSubtitulo().setText(subtitulo);
		getAlerta().setVisible(false);
		getIcone().setIcon(new ImageIcon(JD_Cadastro.class.getResource("/br/com/cgpp/vendas/img/1427155664_xmag.png")));
		getJButton_salvar().setIcon(new ImageIcon(JD_Listagem.class.getResource("/br/com/cgpp/vendas/img/1427155999_xmag.png")));
		getJButton_salvar().setText("Procurar");
		getJButton_salvar().setToolTipText("Procurar registro");
		this.dao = new HibernateDAO<Categoria>(Categoria.class);
		this.cat = new Categoria();
		this.cat.setIdcategoria(procurar);
		addEventos();
		setModal(false);		
		//setVisible(true);
	}

	public void addEventos(){
		getJButton_salvar().addActionListener(this);
		getJButton_fechar().addActionListener(this);
		digitou();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getJButton_salvar()) {
			cadastrar();
		} else
			
		if (e.getSource() == getJButton_fechar()){
			fechar();
		}
	}

	private void fechar() {
		dispose();
	}

	private void cadastrar() {
		Categoria cat = new Categoria();
		boolean podeSalvar = preencheBean(cat);
		
		if(this.cat.getIdcategoria() == -1){
			//Objeto contendo parametros para filtrar registros
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("nome", getNomeJTextField().getText());
			params.put("descricao", getDescricaoJTextArea().getText());
			
			//parametros para ordenação
			String [] orderBy = new String [1];
			orderBy[0] = "nome";
			
			ListarCategoria.listarTable(dao.findByCriteria(params, orderBy));
		}else
			
		if (podeSalvar){
			if (this.cat.getIdcategoria() == 0) {
					this.dao.salvar(cat);	
					this.UIUtils.displayAlertSucess(this, "Sucesso", "Registro salvo com sucesso.");
					limparCampos();
			}else {
				cat.setIdcategoria(this.cat.getIdcategoria());
				this.dao.atualizar(cat);
				this.UIUtils.displayAlertSucess(this, "Sucesso", "Registro atualizado com sucesso.");
			}
				
		} else
			if (qtdErroCampoObrt > 1) UIUtils.displayAlert(this, "Formulário ", "Os campos abaixo requerem preenchimento obrigatório: " + "\n" + campoObrigatorio);	
			else this.UIUtils.displayAlert(this, "Formulário ", "O campo abaixo requer preenchimento obrigatório: " + "\n" + campoObrigatorio);
	}

	private void limparCampos() {
		getNomeJTextField().setText("");
		getDescricaoJTextArea().setText("");		
	}

	private boolean preencheBean(Categoria cat) {
		if (this.cat.getIdcategoria() == -1) { //  idcategoria == -1 servirá para executar o metodo de procura
			cat.setNome(getNomeJTextField().getText());
			cat.setDescricao(getDescricaoJTextArea().getText());
			return true;
		}else
		if (getNomeJTextField().getText().isEmpty()) {
			cat.setNome(getNomeJTextField().getText());
			cat.setDescricao(getDescricaoJTextArea().getText());
			return true;
		} else {
			campoObrigatorio = "Nome";
			qtdErroCampoObrt++;
			getNomeJTextField().setBorder(new LineBorder(new Color(255, 0, 0)));
			getAlerta().setForeground(Color.RED);
			getNomeJTextField().grabFocus();
			return false;
		}
	}
	
	public void digitou (){
		getNomeJTextField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {				
				getNomeJTextField().setBorder(UIManager.getBorder("TextField.border"));
				getAlerta().setForeground(new Color(51, 51, 51));
			}
		});
	}
}
