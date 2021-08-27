package edu.vinaenter.cland.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.cland.daos.CategoryDAO;
import edu.vinaenter.cland.models.Category;
import edu.vinaenter.cland.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDAO catDAO;
	
	@Override
	public List<Category> findAll() {
		return catDAO.findAll();
	}

	@Override
	public int add(Category cat) {
		return catDAO.add(cat);
	}

	@Override
	public Category findOne(int id) {
		return catDAO.findOne(id);
	}

	@Override
	public int edit(Category cat) {
		return catDAO.edit(cat);
	}

	@Override
	public int del(int id) {
		return catDAO.del(id);
	}

	@Override
	public int countCat() {
		return catDAO.countCat();
	}

	@Override
	public List<Category> findAll(int offset, int limit) {
		return catDAO.findAll(offset, limit);
	}

	@Override
	public Category findCid(int lid) {
		return catDAO.findCid(lid);
	}

	@Override
	public List<Category> searchCat(String searchCat) {
		return catDAO.searchCat(searchCat);
	}
}
