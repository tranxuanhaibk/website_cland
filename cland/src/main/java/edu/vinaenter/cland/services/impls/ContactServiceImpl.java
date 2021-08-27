package edu.vinaenter.cland.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.cland.daos.ContactDAO;
import edu.vinaenter.cland.models.Contact;
import edu.vinaenter.cland.services.ContactService;
@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	public List<Contact> findAll() {
		return contactDAO.findAll();
	}

	@Override
	public int add(Contact contact) {
		return contactDAO.add(contact);
	}

	@Override
	public int del(int cid) {
		return contactDAO.del(cid);
	}

	@Override
	public int edit(Contact contact, int cid) {
		return contactDAO.edit(contact, cid);
	}

	@Override
	public Contact findOne(int cid) {
		return contactDAO.findOne(cid);
	}

	@Override
	public int countContact() {
		return contactDAO.countContact();
	}

	@Override
	public List<Contact> findAll(int offset, int limit) {
		return contactDAO.findAll(offset, limit);
	}

}
