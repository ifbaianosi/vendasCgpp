package br.com.cgpp.vendas.utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

/**
 * Classe com métodos utilitários para serem utilizados pela interface gráfica
 */
public class UIUtils {

	/**
	 *Objeto que fornece as propriedades de log da classe
	 */
	//private static final Logger LOGGER = LoggerFactory.getLogger(UIUtils.class);
	
	private Icon iconWarning = new ImageIcon(getClass().getResource("/br/com/cgpp/vendas/img/notification_warning.png"));	
	private Icon iconSucess = new ImageIcon(getClass().getResource("/br/com/cgpp/vendas/img/notification_sucess.png"));
	private Icon iconException = new ImageIcon(getClass().getResource("/br/com/cgpp/vendas/img/notification_error.png"));
	private Icon iconQuestion = new ImageIcon(getClass().getResource("/br/com/cgpp/vendas/img/notification_question.png"));
	/*private Icon iconInformation = new ImageIcon(getClass().getResource("/Img/information.png"));	*/
	
	/**
	 * Centraliza a janela na tela
	 * @param window Janela a ser centralizada
	 */
	public static void centerWindow(Window window) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		// Obtém a resolução da tela
		Dimension screenSize = toolkit.getScreenSize();
		
		// Posiciona a janela no meio da tela, com base na resolução da tela
		window.setLocation(screenSize.width / 2 - window.getWidth() / 2, screenSize.height / 2 - window.getHeight() / 2);
	}
	
	/**
	 * Exibe uma caixa de diálogo de erro
	 * @param parent Componente pai da caixa de diálogo. Se for fornecido, a caixa será alinhada de 
	 * 				 acordo com o componente pai. Pode ser null.
	 * @param e Exceção ocorrida. A mensagem da exceção será utilizada como mensagem na caixa de diálogo.
	 */
	public void displayException(Component parent, Exception e) {
		Toolkit.getDefaultToolkit().beep();	
		// Imprime a exceção no console
		//LOGGER.error(e.getMessage());
		e.printStackTrace();
		if (e.getMessage().contains("Cannot delete or update a parent row: a foreign key constraint fails")) {
			JOptionPane.showMessageDialog(parent, "Registro não pode ser excluido"+"\npossui referencias com outras tabelas", "erro - Exceção lançada", JOptionPane.ERROR_MESSAGE, iconException);
		}else		
			// Exibe a caixa de diálogo
			JOptionPane.showMessageDialog(parent, e.getMessage(), "erro - Exceção lançada", JOptionPane.ERROR_MESSAGE, iconException);
	}
	
	/**
	 * Exibe uma caixa de diálogo de erro
	 * @param parent Componente pai da caixa de diálogo. Se for fornecido, a caixa será alinhada de 
	 * 				 acordo com o componente pai. Pode ser null.
	 * @param e Exceção ocorrida. A mensagem da exceção será utilizada como mensagem na caixa de diálogo.
	 */
	public void displayException(Component parent, Exception e, String mensagemErroPersonalizada) {
		Toolkit.getDefaultToolkit().beep();	
		// Imprime a exceção no console
		///LOGGER.error(e.getMessage());
		e.printStackTrace();
		// Exibe a caixa de diálogo
		JOptionPane.showMessageDialog(parent, mensagemErroPersonalizada+"\n"+e.getMessage(), "erro - Exceção lançada", JOptionPane.ERROR_MESSAGE, iconException);
	}
	
	/**
	 * Exibe uma caixa de diálogo de erro
	 * @param parent Componente pai da caixa de diálogo. Se for fornecido, a caixa será alinhada de 
	 * 				 acordo com o componente pai. Pode ser null.
	 * @param e Exceção ocorrida. A mensagem da exceção será utilizada como mensagem na caixa de diálogo.
	 */
	public void displayExceptionDAOException(Component parent, Exception e) {
		Toolkit.getDefaultToolkit().beep();	
		// Imprime a exceção no console
		//LOGGER.error(e.getMessage());
		e.printStackTrace();
		// Exibe a caixa de diálogo
		StringBuilder mensagemErro = new StringBuilder();
		mensagemErro.append("Problemas ao tentar acessar o BANCO DE DADOS, repita a operação novamente. \nCaso o erro persista contate o administrador do sistema.");
		mensagemErro.append("\n\nerro: ");
		mensagemErro.append(e.getMessage());
		JOptionPane.showMessageDialog(parent, mensagemErro, "erro - Exceção lançada", JOptionPane.ERROR_MESSAGE, iconException);
	}
	
	/**
	 * Exibe uma caixa de diálogo de sucesso
	 * @param parent Componente pai da caixa de diálogo. Se for fornecido, a caixa será alinhada de 
	 * 				 acordo com o componente pai. Pode ser null.
	 * @param title Título da caixa de sucesso.
	 * @param message Mensagem a ser exibida.
	 */
	public void displayAlertSucess(Component parent, String title, String message) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE, iconSucess);
	}
	
	/**
	 * Exibe uma caixa de diálogo de alerta
	 * @param parent Componente pai da caixa de diálogo. Se for fornecido, a caixa será alinhada de 
	 * 				 acordo com o componente pai. Pode ser null.
	 * @param title Título da caixa de alerta.
	 * @param message Mensagem a ser exibida.
	 */
	public void displayAlert(Component parent, String title, String message) {
		JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE, iconWarning);
	}
	
	/**
	 * Exibe uma caixa de diálogo que exige confirmação do usuário
	 * @param parent Componente pai da caixa de diálogo. Se for fornecido, a caixa será alinhada de 
	 * 				 acordo com o componente pai. Pode ser null.
	 * @param message Mensagem a ser exibida.
	 * @return true se o usuário escolheu a opção 'Sim'; false se escolheu 'Não'.
	 */
	public boolean displayConfirmation(Component parent, String message) {
		int result = JOptionPane.showConfirmDialog(parent, message, "Confirme sua ação", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, iconQuestion);
		
		if (result == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Exibe uma caixa de diálogo que exige confirmação do usuário
	 * @param parent Componente pai da caixa de diálogo. Se for fornecido, a caixa será alinhada de 
	 * 				 acordo com o componente pai. Pode ser null.
	 * @param message Mensagem a ser exibida.
	 * @return true se o usuário escolheu a opção 'Sim'; false se escolheu 'Não'.
	 */
	public boolean displayConfirmation2(Component parent, String message) {
		String opcoes [] = {"Sim", "Não", ""};
		int result = JOptionPane.showConfirmDialog(parent, message, "Confirme sua ação", JOptionPane.YES_NO_OPTION);
		
		if (result == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
}
