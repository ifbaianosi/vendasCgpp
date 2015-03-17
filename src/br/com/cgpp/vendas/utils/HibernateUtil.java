package br.com.cgpp.vendas.utils;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static
	{
		//sessionFactory = new Configuration().configure("br/com/sisman/util/hibernate.cfg.xml").buildSessionFactory();
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://10.90.3.78:3306/vendasCgpp");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "abcif2014");
		configuration.setProperty("hibernate.c3p0.min_size", "1");
		configuration.setProperty("hibernate.c3p0.max_size", "5");
		configuration.setProperty("hibernate.c3p0.timeout", "300");
		configuration.setProperty("hibernate.c3p0.max_statements", "50");
		configuration.setProperty("hibernate.c3p0.idle_test_period", "300");
		configuration.setProperty("hibernate.current_session_context_class", "thread");
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.setProperty("hibernate.format_sql", "true");
		
		configuration.addResource("br/com/cgpp/vendas/model/bean/Categoria.hbm.xml");
		
		sessionFactory = configuration.buildSessionFactory();
	}

	/*private SessionFactory getSessionFactoryCodigo()
	{
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/sisman_teste");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "abcif2010");
		configuration.setProperty("hibernate.c3p0.min_size", "1");
		configuration.setProperty("hibernate.c3p0.max_size", "5");
		configuration.setProperty("hibernate.c3p0.timeout", "300");
		configuration.setProperty("hibernate.c3p0.max_statements", "50");
		configuration.setProperty("hibernate.c3p0.idle_test_period", "300");
		configuration.setProperty("hibernate.current_session_context_class", "thread");
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.setProperty("hibernate.format_sql", "true");
		configuration.addResource("br/com/siscom/model/bean/Fornecedor.hbm.xml");
		configuration.addResource("br/com/siscom/model/bean/Produto.hbm.xml");
		configuration.addResource("br/com/siscom/model/bean/Unidade.hbm.xml");
		return configuration.buildSessionFactory();
	}*/
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
