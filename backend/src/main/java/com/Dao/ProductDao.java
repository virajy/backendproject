package com.Dao;

import java.util.List;

import com.model.Product;

public interface ProductDao 
{
public boolean addProduct(Product p);
public boolean deleteProduct(Product p);
public boolean updateProduct(Product p);
//public void getproduct(Product p);
public List<Product> displayall();

}
