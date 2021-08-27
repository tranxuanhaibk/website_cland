package edu.vinaenter.cland.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.cland.daos.UserDAO;
import edu.vinaenter.cland.models.User;
import edu.vinaenter.cland.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public int del(int id) {
		return userDAO.del(id);
	}


	@Override
	public User findOne(int id) {
		return userDAO.findOne(id);
	}

	@Override
	public int add(User user, int roleId) {
		return userDAO.add(user,roleId);
	}

	@Override
	public int edit(User user, int id) {
		return userDAO.edit(user,id);
	}

	@Override
	public int countUser() {
		return userDAO.countUser();
	}

	@Override
	public List<User> findAll(int offset, int limit) {
		return userDAO.findAll(offset, limit);
	}

}
