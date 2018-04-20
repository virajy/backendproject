package com.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.ProductDao;
import com.config.Hibernateconfig;
import com.model.Product;

public  class Productdaoimpl implements ProductDao
{
	@Autowired
	SessionFactory sessionfactory;

	@Transactional
	public boolean addProduct(Product p) 
	{
		try
		{
		Hibernateconfig hc=new Hibernateconfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		s.beginTransaction();
		s.save(p);
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
	public boolean deleteProduct(Product p) {
	try{
		Hibernateconfig hc=new Hibernateconfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		s.beginTransaction();
		s.delete(p);;
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

	public boolean updateProduct(Product p) 
	{
		try
		{
			Hibernateconfig hc=new Hibernateconfig();
			sessionfactory=hc.getSessionFactory();
			Session s=sessionfactory.openSession();
			s.beginTransaction();
			s.update(p);;
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
	public List<Product> displayall() 
	{
		Hibernateconfig hc=new Hibernateconfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
		List<Product> l=s.createQuery("from com.model.Product").list();
		/*for (Product product : l) 
		{
			System.out.println(product.getBrand());
			System.out.println(product.getId());
			System.out.println(product.getPrice());
			System.out.println(product.getDiscription());
		}
		s.close();*/
		s.close();
		return l;
	}

	/*public void getproduct(Product p)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter product id");
		int a=sc.nextInt();
		Hibernateconfig hc=new Hibernateconfig();
		sessionfactory=hc.getSessionFactory();
		Session s=sessionfactory.openSession();
	Query q=s.createQuery("from com.model.Product p where p.p_id= :id");
	q.setParameter("id", a);
	List<Product> product=q.list();
	for (Product product2 : product) 
	{
		System.out.println(product2.getP_quantity());
		System.out.println(product2.getPrice());
		System.out.println(product2.getBrand());
		System.out.println(product2.getDiscription());
	}
		
	}
	*/

}
