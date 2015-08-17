package testeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.cgpp.vendas.view.JDialog_listar_categorias;

public class ListarCategorias extends JDialog_listar_categorias {

	public ListarCategorias() {
		getJMenuItem_editar().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastrarCategoria().setVisible(true);
			}
		});
	}

}