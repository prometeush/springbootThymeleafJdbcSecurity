package com.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.project.entity.Angestellte;
import com.project.entity.Users;

@Repository
public class UsersRepository {
	
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public List<Users> usersListAll(){
		String sql="select * from users";
		List<Users> list=this.jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Users.class));
		return list;
	}
	
	public void usersSave(Users users) {
		users.setPassword(passwordEncoder().encode(users.getPassword()));
		SimpleJdbcInsert insert=new SimpleJdbcInsert(jdbcTemplate);
		insert.withTableName("users").usingColumns("username","password","role","enabled");
		BeanPropertySqlParameterSource parameterSource=new BeanPropertySqlParameterSource(users);
		insert.execute(parameterSource);
	}
	
	public void usersDelete(Integer id) {
		String sql="delete from users where id=?";
		this.jdbcTemplate.update(sql, new Object[] {id});
	}
	
	
	

}
