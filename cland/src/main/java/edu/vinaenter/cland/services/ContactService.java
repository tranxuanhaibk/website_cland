package edu.vinaenter.cland.services;

import java.util.List;

import edu.vinaenter.cland.models.Contact;

public interface ContactService {
	
	List<Contact> findAll();
	
	Contact findOne(int cid);
	
	int add(Contact contact);
	
	int del(int cid);
	
	int edit(Contact contact, int cid);
	
	int countContact();
	
	List<Contact> findAll(int offset, int limit);
	

}
