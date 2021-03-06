package br.com.cgpp.vendas.controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.HibernateException;

import br.com.cgpp.vendas.model.bean.Categoria;
import br.com.cgpp.vendas.model.bean.PesCategoriaTableModel;
import br.com.cgpp.vendas.model.dao.HibernateDAO;
import br.com.cgpp.vendas.utils.UIUtils;
import br.com.cgpp.vendas.view.JD_listar_categoria;


public class ListarCategoria extends JD_listar_categoria implements ActionListener, MouseListener, KeyListener{

	
	private HibernateDAO<Categoria> dao;
	
	private UIUtils UIUtils;
	
	private PesCategoriaTableModel modelcat;
	
	
	public ListarCategoria(Frame owner, String titulo, String subtitulo) {
		super(owner);
		getTitulo().setText(titulo);
		getSubtitulo().setText(subtitulo);
		this.dao = new HibernateDAO<Categoria>(Categoria.class);
		this.UIUtils = new UIUtils();
		encheTabela(dao.getBeans());
		
		//listar();
		addEventos();
		setVisible(true);
	}

	private void addEventos() {
		getJButton_novo().addActionListener(this);
		getJButton_editar().addActionListener(this);
		getJButton_procurar().addActionListener(this);
		getJButton_fechar().addActionListener(this);
		getBtnExcluir().addActionListener(this);
		
		getJTable().addMouseListener(this);
		getJTable().addKeyListener(this);
				
		getJMenuItem_novo().addActionListener(this);
		getJMenuItem_editar().addActionListener(this);
		getJMenuItem_procurar().addActionListener(this);
		getJMenuItem_excluir().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getJButton_novo() || e.getSource() == getJMenuItem_novo()){
			novo();
		}else
			
		if (e.getSource() == getJButton_editar() || e.getSource() == getJMenuItem_editar() ){ 
			editar();
		} else
		
		if(e.getSource() == getJButton_procurar() || e.getSource() == getJMenuItem_procurar()){
			procurar();
		} else
			
		if (e.getSource() == getBtnExcluir() || e.getSource() == getJMenuItem_excluir()){
			excluir();
		}else
			
		if (e.getSource() == getJButton_fechar()){
			dispose();
		} 
	}
	
	private void novo() {
		new CadastrarCategoria(this, "Categoria", "Cadastrar uma nova categoria").setVisible(true);
		listar();
	}

	private void editar() {
		int linhaselecionada = getJTable().getSelectedRow();		
		
		if (getJTable().getSelectedRowCount() > 0)
		{
			Categoria categoria = new Categoria();
			categoria.setIdcategoria(Integer.parseInt(getJTable().getValueAt(linhaselecionada, 0).toString()));			
			
			new CadastrarCategoria(this, categoria, "Editar Categoria", "Atualiza as informa��es alteradas.").setVisible(true);
			//janelac.setVisible(true);;
			
			getJButton_editar().grabFocus();
			try {
				encheTabela(dao.getBeans());
				//listarTable(dao.getBeans());
				getJTable().setRowSelectionInterval(linhaselecionada, linhaselecionada);
				getModelcat().limpar();
				encheTabela(dao.getBeans());
				getJTable().setRowSelectionInterval(linhaselecionada, linhaselecionada);
			} catch (Exception e) {
				UIUtils.displayException(this, e);
			}			
		}else {
			UIUtils.displayAlert(this, "Selecione um registro ", "Selecione um registro na tabela e clique em editar");
		}
			
	}
	
	private void procurar() {
		new CadastrarCategoria(this, "Procurar Categoria", "Informe os parametros de pesquisa para procurar um registro.", -1).setVisible(true);;
	}


	private void excluir() {
		int linhaselecionada = getJTable().getSelectedRow();		
		
		if (getJTable().getSelectedRowCount() > 0)
		{
			Categoria categoria = new Categoria();
			categoria.setIdcategoria(Integer.parseInt(getJTable().getValueAt(linhaselecionada, 0).toString()));	
			categoria.setNome(getJTable().getValueAt(linhaselecionada, 1).toString());

			if (UIUtils.displayConfirmation(this, "Deseja realmente excluir o registro: \n"+categoria.getNome().toUpperCase()))
			{
				getBtnExcluir().requestFocus();				
				dao.excluir(categoria);
				UIUtils.displayAlertSucess(this, "Sucesso", "registro "+categoria.getNome().toUpperCase()+" excluido com sucesso !");
				
				// atualizar a tabela ao excluir um registro
				try {
					listarTable(dao.getBeans());
				} catch (HibernateException e) {
					UIUtils.displayException(this, e);
				}
			}			
		}else {
			UIUtils.displayAlert(this, "Selecione um registro ", "Selecione um registro na tabela e clique em excluir");
		}
	}
	private void listar() {			
			new Thread()
			{
				public void run()
				{
					try {
						jLabel2.setText("Aguarde, Obtendo registros ...");
						jLabel2.setIcon(new ImageIcon(getClass().getResource("/br/com/cgpp/vendas/img/ajax-loader.gif")));
						listarTable(dao.getBeans());
						
					} catch (HibernateException e) {
						//UIUtils.displayException(rootPane, e);
						jLabel2.setText("problemas na conex�o com o banco de dados. "+e.getMessage());
						jLabel2.setIcon(new ImageIcon(getClass().getResource("/br/com/cgpp/vendas/img/erro.png")));
						e.printStackTrace();
					} finally{
						//jLabel2.setIcon(null);
					}
				}
			}.start();
	}

	private void encheTabela(List<Categoria> categorias){
		
		if (categorias.size() > 0)
		{
			for (int i = 0; i < categorias.size(); i++)
			{
				Categoria categoria = categorias.get(i);
				getModelcat().addCat(new Categoria(categoria.getIdcategoria(), categoria.getNome(), categoria.getDescricao()));
			}
			getJTable().setModel(getModelcat());
			
		}
		
	}
	
	private PesCategoriaTableModel getModelcat() {
		if (modelcat == null) {
			modelcat = (PesCategoriaTableModel) getTblCat().getModel();
		}
		return modelcat;
	}
	
	private JTable getTblCat() {
		getJTable().setModel(new PesCategoriaTableModel());
		return getJTable();
	}
	
	
	private static Object linhas [][];
	private static String cabecalho [] = {"ID", "NOME", "DESCRIC�O"};
	
	public static void listarTable(List<Categoria> categorias)
	{
		
		if (categorias.size() > 0)
		{
			 linhas = new Object [categorias.size()][3];
			for (int i = 0; i < categorias.size(); i++)
			{
				Categoria categoria = categorias.get(i);
				linhas [i][0] = categoria.getIdcategoria();
				linhas [i][1] = categoria.getNome();
				linhas [i][2] = categoria.getDescricao();
			}
			
			
			getJTable().setModel(new DefaultTableModel(
					linhas,
					cabecalho
			){
				private static final long serialVersionUID = 1L;
				boolean[] canEdit = new boolean []{false, false, false};
			    public boolean isCellEditable(int rowIndex, int columnIndex) 
			    {
			       return canEdit [columnIndex];
			    }
			 }
			);
		}else			
		{
			String cabecalho [] = {"ID", "NOME", "DESCRI��O"};
			
			getJTable().setModel(new DefaultTableModel(
					new Object [0][0],
					cabecalho
			));
		}
		
		jLabel2.setIcon(null);
		jLabel2.setText("Registros: "+categorias.size()+"  ");
		
		getJTable().getColumnModel().getColumn(0).setPreferredWidth(60);
		
		getJTable().getColumnModel().getColumn(1).setPreferredWidth(180);
		
		getJTable().getColumnModel().getColumn(2).setPreferredWidth(400);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {	
		if (e.getClickCount()==2)
			editar();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)			
			editar();		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
