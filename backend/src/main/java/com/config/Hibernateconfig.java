package com.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.Dao.Categorydao;
import com.Dao.ProductDao;
import com.Dao.Supplierdao;
import com.daoImpl.Categorydaoimpl;
import com.daoImpl.Productdaoimpl;
import com.daoImpl.Supplierdaoimpl;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class Hibernateconfig 
{
public static SessionFactory sessionfactory=null;
@Bean(name="datasource")
public DriverManagerDataSource datasource()
{
	DriverManagerDataSource dmds=new DriverManagerDataSource();
	dmds.setDriverClassName("org.h2.Driver");
	dmds.setUrl("jdbc:h2:tcp://localhost/~/shoesmart");
	dmds.setUsername("viraj");
	dmds.setPassword("");
	return dmds;
}

@Autowired
@Bean(name="getsession")
public SessionFactory getSessionFactory()
{
	LocalSessionFactoryBuilder ls=null;


	
	Properties hp=new Properties();
	hp.put("hibernate.temp.use_jdbc_metadata_defaults","false");
	//hp.setProperty("hibernate.hbm2ddl.auto","update");
	hp.setProperty("hibernate.hbm2ddl.auto","none");
	hp.put("hibernate.show_sql", "true");
	hp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	
	ls=new LocalSessionFactoryBuilder(datasource());
	ls.addProperties(hp);

	ls.addAnnotatedClass(Category.class);
	ls.addAnnotatedClass(Supplier.class);
	ls.addAnnotatedClass(Product.class);
	
	sessionfactory=ls.buildSessionFactory();
	System.out.println("Session Factory Object Created");
	return sessionfactory;
	
	}
@Autowired
@Bean(name="gethibernatemanager")
public  HibernateTransactionManager gethibernatemanager(SessionFactory sf)
{
	HibernateTransactionManager htm=new HibernateTransactionManager();
	htm.setSessionFactory(sf);
	return htm;
	
	
}

@Bean(name="getproductdao")
public ProductDao getproductdao()
{
	return new Productdaoimpl();
}

@Bean(name="getcategorydao")
public Categorydao getcategorydao()
{
	return new Categorydaoimpl();
}

@Bean(name="getsupplierdao")
public Supplierdao getsupplierdao()
{
	return new Supplierdaoimpl();
}


}
