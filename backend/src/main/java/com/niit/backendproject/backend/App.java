package com.niit.backendproject.backend;

import java.util.HashSet;
import java.util.Set;

import com.Dao.Categorydao;
import com.Dao.ProductDao;
import com.Dao.Supplierdao;
import com.daoImpl.Categorydaoimpl;
import com.daoImpl.Productdaoimpl;
import com.daoImpl.Supplierdaoimpl;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;


public class App 
{

	
    public static void main( String[] args )
    {
    	Category c=new Category();
    	c.setC_id(101);
    	Categorydaoimpl cdi=new Categorydaoimpl();
    	boolean f=cdi.Delete(c);
    	Supplier s=new Supplier();
    	s.setS_id(111);
    	Supplierdaoimpl sdi=new Supplierdaoimpl();	
    }
}
