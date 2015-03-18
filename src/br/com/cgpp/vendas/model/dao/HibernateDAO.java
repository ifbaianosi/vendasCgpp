package br.com.cgpp.vendas.model.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.cgpp.vendas.utils.HibernateUtil;

public class HibernateDAO<T> implements InterfaceDAO<T> {

	private Class<T> classe;
	private Session session;
	
	public HibernateDAO(Class<T> classe) {
		super();
		this.classe = classe;
	}

	@Override
	public void salvar(T bean) {
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//método responsável por salvar um registro na base de dados
			session.save(bean);
			
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}		
	}

	@Override
	public void atualizar(T bean) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//método responsável por atualizar um registro na base de dados
			session.update(bean);
			
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(T bean) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//método responsável por deletar um registro na base de dados
			session.delete(bean);
			
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public T getBean(Serializable codigo) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//método responsável por retornar um registro na base de dados

			@SuppressWarnings("unchecked")
			T bean = (T)session.get(classe, codigo);
			
			session.getTransaction().commit();
			session.close();

			return bean;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<T> getBeans() {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			//será
			//método responsável por retornar todos os registros de uma tabela na base de dados
			@SuppressWarnings("unchecked")
			List<T> beans = (List<T>) session.createCriteria(classe).list();
			
			session.getTransaction().commit();
			session.close();

			return beans;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return null;		
		
	}

	
	/*
    Os argumentos são:
    @param clazz: Classe que será a base da consulta.
    @param params: HashMap<String, Object> que tem como key (chave) o nome da propriedade e como value (valor) o objeto a ser utilizado como filtro.
	*/
	@Override
	public List<T> findByCriteria(Map<String, Object> params, String[] orderBy) {
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			//método responsável por retornar todos os registros de uma tabela na base de dados baseado nos campos definidos para busca
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
	        
			session.getTransaction().commit();
			session.close();
		    
		    @SuppressWarnings("unchecked")
			List<T> beans = (List<T>) criteria.list();
			return beans;

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return null;	    
	}
	

}
