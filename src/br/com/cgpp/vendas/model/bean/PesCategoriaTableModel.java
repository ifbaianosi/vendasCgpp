package br.com.cgpp.vendas.model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;



@SuppressWarnings("serial")
public class PesCategoriaTableModel extends AbstractTableModel{

	/* Lista de S�cios que representam as linhas. */
	private List<Categoria> linhas;

	/* Array de Strings com o nome das colunas. */
	private String[] colunas = new String[] {
			"Id", "Nome", "Descri��o"};


	public String[] criaColunas(){
		
		return colunas;
	}
	
	/* Cria um SocioTableModel vazio. */
	public PesCategoriaTableModel() {
		linhas = new ArrayList<>();
	}

	/* Cria um SocioTableModel carregado com
	 * a lista de s�cios especificada. */
	public PesCategoriaTableModel(List<Categoria> listaCat) {
		linhas = new ArrayList<Categoria>(listaCat);
	}


	/* Retorna a quantidade de colunas. */
	@Override
	public int getColumnCount() {
		// Está retornando o tamanho do array "colunas".
		// Mas como o array é fixo, vai sempre retornar 4.
		return colunas.length;
	}

	/* Retorna a quantidade de linhas. */
	@Override
	public int getRowCount() {
		// Retorna o tamanho da lista de s�cios.
		return linhas.size();
	}

	/* Retorna o nome da coluna no índice especificado.
	 * Este método é usado pela JTable para saber o texto do cabeçalho. */
	@Override
	public String getColumnName(int columnIndex) {
		// Retorna o conteúdo do Array que possui o nome das colunas
		// no índice especificado.
		return colunas[columnIndex];
	};

	/* Retorna a classe dos elementos da coluna especificada.
	 * Este método é usado pela JTable na hora de definir o editor da célula. */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// Retorna a classe referente a coluna especificada.
		// Aqui é feito um switch para verificar qual é a coluna
		// e retornar o tipo adequado. As colunas são as mesmas
		// que foram especificadas no array "colunas".
		switch (columnIndex) {
		case 0: // Primeira coluna é o nome, que é uma String.
			return Integer.class;
		case 1: // Segunda coluna é o telefone, que também é uma String..
			return String.class;
		case 2:
			return String.class;
		default:
			// Se o índice da coluna não for válido, lança um
			// IndexOutOfBoundsException (Exceção de índice fora dos limites).
			// Não foi necessário verificar se o índice da linha é inválido,
			// pois o pr�prio ArrayList lança a exceção caso seja inválido.
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	/* Retorna o valor da célula especificada
	 * pelos índices da linha e da coluna. */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Pega o sócio da linha especificada.
		Categoria cat = linhas.get(rowIndex);

		// Retorna o campo referente a coluna especificada.
		// Aqui é feito um switch para verificar qual é a coluna
		// e retornar o campo adequado. As colunas são as mesmas
		// que foram especificadas no array "colunas".
		switch (columnIndex) {
		case 0: // Primeira coluna é o nome.
			return cat.getIdcategoria();
		case 1: // Segunda coluna é o telefone.
			return cat.getNome();
		case 2:
			return cat.getDescricao();
		default:
			// Se o índice da coluna não for válido, lança um
			// IndexOutOfBoundsException (Exceção de índice fora dos limites).
			// Não foi necessário verificar se o índice da linha é inválido,
			// pois o próprio ArrayList lança a exceção caso seja inválido.
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	/* Seta o valor da célula especificada
	 * pelos índices da linha e da coluna.
	 * Aqui ele está implementado para não fazer nada,
	 * até porque este table model não é editável. */
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {};

	/* Retorna um valor booleano que define se a célula em questão
	 * pode ser editada ou não.
	 * Este método é utilizado pela JTable na hora de definir o editor da célula.
	 * Neste caso, estará sempre retornando false, não permitindo que nenhuma
	 * célula seja editada. */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}


	////////////////////////////////////////////////////////////
	// Os métodos declarados até aqui foram as implementações //
	// de TableModel, que são continuamente utilizados        //
	// pela JTable para definir seu comportamento,            //
	// por isso o nome Table Model (Modelo da Tabela).        //
	//                                                        //
	// A partir de agora, os métodos criados serão            //
	// particulares desta classe. Eles serão úteis            //
	// em algumas situações.                                  //
	////////////////////////////////////////////////////////////


	/* Retorna o sócio da linha especificada. */
	public Categoria getCat(int indiceLinha) {
		return linhas.get(indiceLinha);
	}
	
	/* Adiciona um registro. */
	public void addCat(Categoria cat) {
		// Adiciona o registro.
		linhas.add(cat);
		
		// Pega a quantidade de registros e subtrai um para achar
		// o último índice. É preciso subtrair um, pois os índices
		// começam pelo zero.
		int ultimoIndice = getRowCount() - 1;

		// Reporta a mudança. O JTable recebe a notificação
		// e se redesenha permitindo que visualizemos a atualização.
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
		//System.out.println("valor id: "+linhas.get(0).getId()+"Ultimo Indice"+ultimoIndice);
	}

	/* Remove a linha especificada. */
	public void removeCat(int indiceLinha) {
		// Remove o sócio da linha especificada.    	
		linhas.remove(indiceLinha);

		// Reporta a mudança. O JTable recebe a notificação
		// e se redesenha permitindo que visualizemos a atualização.
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	/* Adiciona uma lista de sócios ao final dos registros. */
	public void addListaCat(List<Categoria> cat) {
		// Pega o tamanho antigo da tabela.
		int tamanhoAntigo = getRowCount();

		// Adiciona os registros.
		linhas.addAll(cat);

		// Reporta a mudança. O JTable recebe a notificação
		// e se redesenha permitindo que visualizemos a atualização.
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	/* Remove todos os registros. */
	public void limpar() {
		// Remove todos os elementos da lista de s�cios.
		linhas.clear();

		// Reporta a mudança. O JTable recebe a notificação
		// e se redesenha permitindo que visualizemos a atualização.
		fireTableDataChanged();
	}

	/* Verifica se este table model está vazio. */
	public boolean isEmpty() {
		return linhas.isEmpty();
	}

}
