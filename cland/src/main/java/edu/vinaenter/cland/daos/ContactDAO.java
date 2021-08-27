package edu.vinaenter.cland.daos;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.cland.models.Contact;
@Repository
public class ContactDAO extends AbstractDAO {
	
	private static final String FIND_ALL = "SELECT * FROM vnecontact ORDER BY cid DESC";
	private static final String FIND_ALL_PAGINATION = "SELECT * FROM vnecontact ORDER BY cid DESC LIMIT ?,?";
	private static final String SQL_ADD = "INSERT INTO vnecontact(fullname, email, subject, content, phone) VALUES(?, ?, ?, ?, ?)";
	private static final String FIND_ONE = "SELECT * FROM vnecontact WHERE cid = ?";
	private static final String SQL_EDIT = "UPDATE vnecontact SET fullname = ?, email = ?, subject = ?, content = ?, phone = ? WHERE cid = ?";
	private static final String SQL_DEL = "DELETE FROM vnecontact WHERE cid = ?";
	private static final String COUNT_CONTACT = "SELECT COUNT(*) AS count FROM vnecontact";

	public List<Contact> findAll() {
		return getJdbcTemplate().query(FIND_ALL, new BeanPropertyRowMapper<>(Contact.class));
	}

	public int add(Contact contact) {
		return getJdbcTemplate().update(SQL_ADD, new Object[] {contact.getFullname(), contact.getEmail(), contact.getSubject(), contact.getContent(), contact.getPhone()});
	}

	public int del(int cid) {
		return getJdbcTemplate().update(SQL_DEL, new Object[] {cid});
	}

	public int edit(Contact contact, int cid) {
		return getJdbcTemplate().update(SQL_EDIT, new Object[] {contact.getFullname(), contact.getEmail(), contact.getSubject(), contact.getContent(), contact.getPhone(), cid});
	}

	public Contact findOne(int cid) {
		return getJdbcTemplate().queryForObject(FIND_ONE, new Object[] {cid}, new BeanPropertyRowMapper<>(Contact.class));
	}
	public int countContact() {
		return getJdbcTemplate().queryForObject(COUNT_CONTACT, Integer.class);
	}

	public List<Contact> findAll(int offset, int limit) {
		return getJdbcTemplate().query(FIND_ALL_PAGINATION, new Object[] {offset, limit}, new BeanPropertyRowMapper<>(Contact.class));
	}

}
