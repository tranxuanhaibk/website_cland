package edu.vinaenter.cland.services;

import java.util.List;

import edu.vinaenter.cland.models.User;

public interface UserService {
	List<User> findAll();
	
	List<User> findAll(int offset, int limit);
	
	int del(int id);

	User findOne(int id);
	
	int add(User user, int roleId);
	
	int edit(User user, int id);
	
	int countUser();

}
