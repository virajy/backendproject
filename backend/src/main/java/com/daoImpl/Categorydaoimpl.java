package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.Categorydao;
import com.config.Hibernateconfig;
import com.model.Category;
import com.model.Product;

public class Categorydaoimpl implements Categorydao
{
@Autowired
SessionFactory sessionfactory;

@Transactional
public boolean addCategory(Category c) 
{
	try
	{
		Hibernateconfig hc=new Hibernateconfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		s.beginTransaction();
		s.save(c);
		s.getTransaction().commit();
		s.close();
		return true;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return false;
	}

}

@Transactional
public boolean Delete(Category c)
{
	try
	{
		Hibernateconfig hc=new Hibernateconfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		s.beginTransaction();
		s.delete(c);;
		s.getTransaction().commit();
		s.close();
		return true;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return false;
	}

}

@Transactional
public boolean Update(Category c) 
{
	
	try
	{
		Hibernateconfig hc=new Hibernateconfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		s.beginTransaction();
		s.update(c);;
		s.getTransaction().commit();
		s.close();
		return true;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return false;
	}
}

public List<Category> displayall(Category c) 
{
	Hibernateconfig hc=new Hibernateconfig();
	sessionfactory=hc.getSessionFactory();
	Session s=sessionfactory.openSession();
	List<Category> l=s.createQuery("from com.model.Category").list();
	for (Category product : l)
	{
		System.out.println(product.getC_id());
		System.out.println(product.getC_name());
	}
	return null;
}
	
	

}
