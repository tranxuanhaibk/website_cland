package edu.vinaenter.cland.services;

import java.util.List;

import edu.vinaenter.cland.models.Category;

public interface CategoryService {
	
	List<Category> findAll();
	
	List<Category> findAll(int offset, int limit);
	
	List<Category> searchCat(String searchCat);
	
	int add(Category cat);
	
	Category findOne(int id);
	
	Category findCid(int lid);
	
	int edit(Category cat);
	
	int del(int id);
	
	int countCat();
}
