package br.com.cgpp.vendas.controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.management.GarbageCollectorMXBean;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import org.hibernate.HibernateException;

import br.com.cgpp.vendas.model.bean.Categoria;
import br.com.cgpp.vendas.model.dao.HibernateDAO;
import br.com.cgpp.vendas.utils.UIUtils;
import br.com.cgpp.vendas.view.JD_Listagem;
import br.com.cgpp.vendas.view.JD_listar_categoria;
import br.com.cgpp.vendas.view.JF_principal;

public class ListarCategoria extends JD_listar_categoria implements ActionListener, MouseListener, KeyListener{

	private HibernateDAO<Categoria> dao;
	
	private UIUtils UIUtils;
	
	
	public ListarCategoria(Frame owner, String titulo, String subtitulo) {
		super(owner);
		this.titulo.setText(titulo);
		this.subtitulo.setText(subtitulo);
		dao = new HibernateDAO<Categoria>(Categoria.class);
		UIUtils = new UIUtils();
		listar();
		addEventos();
		this.setVisible(true);
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
			new CadastrarCategoria(JF_principal.getFrame(), "Categoria", "Cadastrar uma nova categoria").setVisible(true);;
			listar();
		}else
			
		if (e.getSource() == getJButton_editar() || e.getSource() == getJMenuItem_editar()){
			editar();
		} else
		
		if(e.getSource() == getJButton_procurar() || e.getSource() == getJMenuItem_procurar()){
			new CadastrarCategoria(this, "Procurar Categoria", "Informe os parametros de pesquisa para procurar um registro.", -1);
			//procurar();
		} else
			
		if (e.getSource() == getBtnExcluir() || e.getSource() == getJMenuItem_excluir()){
			excluir();
		}else
			
		if (e.getSource() == getJButton_fechar()){
			dispose();
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
						jLabel2.setText("problemas na conexão com o banco de dados. "+e.getMessage());
						jLabel2.setIcon(new ImageIcon(getClass().getResource("/br/com/cgpp/vendas/img/erro.png")));
						e.printStackTrace();
					} finally{
						//jLabel2.setIcon(null);
					}
				}
			}.start();
	}

	private static Object linhas [][];
	private static String cabecalho [] = {"ID", "NOME", "DESCRICÃO"};
	
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
			String cabecalho [] = {"ID", "NOME", "DESCRIÇÃO"};
			
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

	private void editar() {
		int linhaselecionada = getJTable().getSelectedRow();		
		
		if (getJTable().getSelectedRowCount() > 0)
		{
			Categoria categoria = new Categoria();
			categoria.setIdcategoria(Integer.parseInt(getJTable().getValueAt(linhaselecionada, 0).toString()));			
			
			CadastrarCategoria janela = new CadastrarCategoria(this, categoria, "Editar Categoria", "Atualiza as informações alteradas.");	
			janela.setVisible(true);
			
			getJButton_editar().grabFocus();
			try {			
				listarTable(dao.getBeans());
				getJTable().setRowSelectionInterval(linhaselecionada, linhaselecionada);
			} catch (Exception e) {
				UIUtils.displayException(this, e);
			}			
		}else {
			UIUtils.displayAlert(rootPane, "Selecione um registro ", "Selecione um registro na tabela e clique em editar");
		}
			
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
			UIUtils.displayAlert(rootPane, "Selecione um registro ", "Selecione um registro na tabela e clique em excluir");
		}
	}	
	
	@Override
	public void mouseClicked(MouseEvent e) {	
		if (e.getClickCount() == 2)
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
