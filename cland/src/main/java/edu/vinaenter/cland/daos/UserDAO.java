package edu.vinaenter.cland.daos;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.cland.models.User;

@Repository
public class UserDAO extends AbstractDAO{

	private static final String FIND_ALL = "SELECT * FROM users ORDER BY id DESC";
	private static final String FIND_ALL_PAGINATION = "SELECT * FROM users ORDER BY id DESC LIMIT ?, ?";
	private static final String FIND_ONE = "SELECT id, username, fullname, password FROM users WHERE id = ?";
	private static final String DEL = "DELETE FROM users WHERE id = ?";
	private static final String SQL_ADD = "INSERT INTO users(username,fullname,authorization,password,roleId) VALUES(?,?,?,?,?)";
	private static final String SQL_EDIT = "UPDATE users SET username = ?, fullname = ?, password = ?, authorization = ? WHERE id= ?";
	private static final String COUNT_USER = "SELECT COUNT(*) AS count FROM users";
	
	public List<User> findAll() {
		return getJdbcTemplate().query(FIND_ALL, new BeanPropertyRowMapper<>(User.class));
	}
	public int del(int id) {
		return getJdbcTemplate().update(DEL, new Object[] {id});
	}
	public int add(User user,int roleId) {
		return getJdbcTemplate().update(SQL_ADD, new Object[] {user.getUserName(), user.getFullName(), user.getAuthorization(), user.getPassWord(),roleId});
	}
	public User findOne(int id) {
		return getJdbcTemplate().queryForObject(FIND_ONE, new Object[] {id}, new BeanPropertyRowMapper<>(User.class));
	}
	public int edit(User user, int id) {
		return getJdbcTemplate().update(SQL_EDIT, new Object[] {user.getUserName(), user.getFullName(), user.getPassWord(), user.getAuthorization(), id});
	}
	public int countUser() {
		return getJdbcTemplate().queryForObject(COUNT_USER, Integer.class);
	}
	public List<User> findAll(int offset, int limit) {
		return getJdbcTemplate().query(FIND_ALL_PAGINATION,new Object[] {offset,limit}, new BeanPropertyRowMapper<>(User.class));
	}

}
