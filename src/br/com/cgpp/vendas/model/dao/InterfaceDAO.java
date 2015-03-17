package br.com.cgpp.vendas.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface InterfaceDAO<T> {
	void salvar (T bean);
	void atualizar (T bean);
	void excluir (T bean);
	T getBean (Serializable codigo);
	List<T> getBeans();
	List<T> findByCriteria(Map<String, Object> params, String[] orderBy);
}
