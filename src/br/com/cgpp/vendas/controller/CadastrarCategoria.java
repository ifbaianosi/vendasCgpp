package br.com.cgpp.vendas.controller;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import br.com.cgpp.vendas.model.bean.Categoria;
import br.com.cgpp.vendas.model.dao.HibernateDAO;
import br.com.cgpp.vendas.utils.UIUtils;
import br.com.cgpp.vendas.view.JD_cadastro_categoria;



@SuppressWarnings("serial")
public class CadastrarCategoria extends JD_cadastro_categoria implements ActionListener{

	private HibernateDAO<Categoria> dao;
	private Categoria cat;
	private UIUtils UIUtils;
	private String campoObrigatorio = "";
	
	public CadastrarCategoria(Frame owner, String titulo, String subtitulo) {		
		super(owner);
		UIUtils = new UIUtils();
		this.titulo.setText(titulo);
		this.subtitulo.setText(subtitulo);
		dao = new HibernateDAO<Categoria>(Categoria.class);
		this.cat = new Categoria();
		this.cat.setIdcategoria(0);
		addEventos();
		setModal(true);		
		setVisible(true);
	}
	
	public CadastrarCategoria(Frame owner, Categoria cat, String titulo, String subtitulo) {		
		super(owner);
		UIUtils = new UIUtils();
		this.titulo.setText(titulo);
		this.subtitulo.setText(subtitulo);
		this.cat = cat;
		dao = new HibernateDAO<Categoria>(Categoria.class);
		this.cat = dao.getBean(cat.getIdcategoria());
		getJButton_salvar().setText("Atualizar");
		nomeJTextField.setText(this.cat.getNome());
		descricaoJTextArea.setText(this.cat.getDescricao());
		addEventos();
		setModal(true);		
		setVisible(true);
	}
	
	public CadastrarCategoria(Frame owner, String titulo, String subtitulo, int procurar) {		
		super(owner);	
		UIUtils = new UIUtils();
		this.titulo.setText(titulo);
		this.subtitulo.setText(subtitulo);
		this.alerta.setVisible(false);
		dao = new HibernateDAO<Categoria>(Categoria.class);
		this.cat = new Categoria();
		this.cat.setIdcategoria(procurar);
		getJButton_salvar().setText("Procurar");
		addEventos();
		setModal(false);		
		setVisible(true);
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
			dispose();
		}
	}

	private void cadastrar() {
		Categoria cat = new Categoria();
		boolean podeSalvar = preencheBean(cat);
		
		if(this.cat.getIdcategoria() == -1){
			//Objeto contendo parametros para filtrar registros
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("nome", nomeJTextField.getText());
			params.put("descricao", descricaoJTextArea.getText());
			
			//parametros para ordenação
			String [] orderBy = new String [1];
			orderBy[0] = "nome";
			
			ListarCategoria.listarTable(dao.findByCriteria(params, orderBy));
		}else
			
		if (podeSalvar){
			if (this.cat.getIdcategoria() == 0) {
					dao.salvar(cat);	
					UIUtils.displayAlertSucess(this, "Sucesso", "Registro salvo com sucesso.");
					limparCampos();
			}else {
				cat.setIdcategoria(this.cat.getIdcategoria());
				dao.atualizar(cat);
				UIUtils.displayAlertSucess(this, "Sucesso", "Registro atualizado com sucesso.");
			}
				
		} else
			UIUtils.displayAlert(rootPane, "Formulário ", "O(s) campo(s) abaixo requer(em) preenchimento obrigatório: " + "\n" + campoObrigatorio);	
	}

	private void limparCampos() {
		nomeJTextField.setText("");
		descricaoJTextArea.setText("");		
	}

	private boolean preencheBean(Categoria cat) {
		if (this.cat.getIdcategoria() == -1) { //  idcategoria == -1 servirá para executar o metodo de procura
			cat.setNome(nomeJTextField.getText());
			cat.setDescricao(descricaoJTextArea.getText());
			return true;
		}else
		if (!nomeJTextField.getText().isEmpty()) {
			cat.setNome(nomeJTextField.getText());
			cat.setDescricao(descricaoJTextArea.getText());
			return true;
		} else {
			campoObrigatorio = "Nome";
			nomeJTextField.setBorder(new LineBorder(new Color(255, 0, 0)));
			alerta.setForeground(Color.RED);
			nomeJTextField.grabFocus();
			return false;
		}
	}
	
	public void digitou (){
		nomeJTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {				
				nomeJTextField.setBorder(UIManager.getBorder("TextField.border"));
				alerta.setForeground(new Color(51, 51, 51));
			}
		});
	}
}
