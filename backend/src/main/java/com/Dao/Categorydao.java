package com.Dao;

import java.util.List;

import com.model.Category;

public interface Categorydao
{
 public boolean addCategory(Category c);
 public boolean Delete(Category c);
 public boolean Update(Category c);
 public List<Category> displayall(Category c);
 
}
