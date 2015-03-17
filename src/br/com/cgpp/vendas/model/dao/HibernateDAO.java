package br.com.cgpp.vendas.model.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class HibernateDAO<T> implements InterfaceDAO<T> {

	private Class<T> classe;
	private Session session;
	
	public HibernateDAO(Class<T> classe, Session session) {
		super();
		this.classe = classe;
		this.session = session;
	}

	@Override
	public void salvar(T bean) {		
		session.save(bean);
	}

	@Override
	public void atualizar(T bean) {		
		session.update(bean);
	}

	@Override
	public void excluir(T bean) {
		session.delete(bean);
	}

	@Override
	public T getBean(Serializable codigo) {
		T bean = (T)session.get(classe, codigo);
		return bean;
	}

	@Override
	public List<T> getBeans() {
		List<T> beans = (List<T>) session.createCriteria(classe).list();
		return beans;
	}

	
	/*
    Os argumentos são:
    @param clazz: Classe que será a base da consulta.
    @param params: HashMap<String, Object> que tem como key (chave) o nome da propriedade e como value (valor) o objeto a ser utilizado como filtro.
	*/
	@Override
	public List<T> findByCriteria(Map<String, Object> params, String[] orderBy) {
	    Criteria criteria = session.createCriteria(classe);
	
	    Iterator<String> keys = params.keySet().iterator();
	    
	    while(keys.hasNext()){
	        String key = keys.next();
	        Object param = params.get(key);
	
	        if(param instanceof String){
	            criteria.add(Restrictions.ilike(key, "%" + param + "%"));
	        }else{
	            criteria.add(Restrictions.eq(key, param));
	        }
	    }
        
        if (orderBy != null && orderBy.length > 0) {
        	for (int i = 0; i < orderBy.length; i++){
        		criteria.addOrder( Order.desc(orderBy[i]) );
        	}
        }
        
        
	    
	    List<T> beans = (List<T>) criteria.list();
		return beans;
	}
	

}
