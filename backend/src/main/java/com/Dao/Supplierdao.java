package com.Dao;

import java.util.List;

import com.model.Product;
import com.model.Supplier;

public interface Supplierdao 
{
	public boolean addSupplier(Supplier s);
	public boolean deleteSupplier(Supplier s);
	public boolean updateSupplier(Supplier s);
	public void getSupplier(Supplier s);
	public List<Product> displayall();
}
