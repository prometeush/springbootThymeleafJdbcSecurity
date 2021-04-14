package com.project.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.project.entity.Angestellte;


@Repository
public class AngestellteRepositroy {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Angestellte> angestellteListAll(){
		String sql="select * from angestellte";
		List<Angestellte> list=this.jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Angestellte.class));
		return list;
	}
	
	public void angestellteSave(Angestellte angst) {
		
		SimpleJdbcInsert insert=new SimpleJdbcInsert(jdbcTemplate);
		insert.withTableName("angestellte").usingColumns("vorname","nachname","email","prog_sprache","anfang","gender");
		BeanPropertySqlParameterSource parameterSource=new BeanPropertySqlParameterSource(angst);
		insert.execute(parameterSource);
	}
	
	public void angestellteDelete(Integer id) {
		String sql="delete from angestellte where id=?";
		this.jdbcTemplate.update(sql, new Object[] {id});
	}
	
	public void angestellteUpdate(Angestellte angst) {
		String sql="update angestellte set vorname=:vorname,nachname=:nachname,email=:email,"
				+ "prog_sprache=:prog_sprache,anfang=:anfang,gender=:gender where id=:id";
		BeanPropertySqlParameterSource parameterSource=new BeanPropertySqlParameterSource(angst);
		NamedParameterJdbcTemplate template=new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, parameterSource);
	}
	
	public Angestellte angestellteFindById(Integer id) {
		String sql="select * from angestellte where  id=?";
		Angestellte angst=this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Angestellte.class), new Object[] {id});
		return angst;
	}
	
	

}
